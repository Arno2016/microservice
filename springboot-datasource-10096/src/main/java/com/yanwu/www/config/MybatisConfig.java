/**  
 * All rights Reserved
 * @Title:  MybatisConfig.java   
 * @Package com.yanwu.www.config   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年9月4日 下午4:04:48   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**   
 * @ClassName:  MybatisConfig   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年9月4日 下午4:04:48   
 *     
 * @Copyright: 2018 
 */
@Configuration
@AutoConfigureAfter(DataSourceConfig.class)
@EnableTransactionManagement(order = 10) //切换数据源必须在事务之前
@MapperScan(basePackages="com.yanwu.www.datasource.mapper")
public class MybatisConfig {
	
	@Autowired
	@Qualifier("writeDataSource")
	private DataSource writeDataSource;
	
	@Autowired
	@Qualifier("readDataSource01")
	private DataSource readDataSource01;
	
	@Autowired
	@Qualifier("readDataSource02")
	private DataSource readDataSource02;
	
	@Value("${readDataSourceSize}")
	private int readDataSourceSize;
	
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactorys() throws Exception {
		
		System.out.println("-------------------- sqlSessionFactory init---------------------");
		
		try {
			
			SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
			sessionFactoryBean.setDataSource(roundRobinDataSouceProxy());

			// 读取配置
			// sessionFactoryBean.setTypeAliasesPackage("com.fei.springboot.domain");

			// 设置mapper.xml文件所在位置
			// Resource[] resources = new
			// PathMatchingResourcePatternResolver().getResources(mapperLocations);
			// sessionFactoryBean.setMapperLocations(resources);

			// 设置mybatis-config.xml配置文件位置
			// sessionFactoryBean.setConfigLocation(new
			// DefaultResourceLoader().getResource(configLocation));

			// 添加分页插件、打印sql插件
			// Interceptor[] plugins = new Interceptor[]{pageHelper(),new
			// SqlPrintInterceptor()};
			// sessionFactoryBean.setPlugins(plugins);

			return sessionFactoryBean.getObject();
		} catch (IOException e) {
			// log.error("mybatis resolver mapper*xml is error",e);
			return null;
		} catch (Exception e) {
			// log.error("mybatis sqlSessionFactoryBean create error",e);
			return null;
		}
	}
	  
	/*  
	   // 分页插件
	    @Bean
	    public PageHelper pageHelper() {
	        PageHelper pageHelper = new PageHelper();
	        Properties p = new Properties();
	        p.setProperty("offsetAsPageNum", "true");
	        p.setProperty("rowBoundsWithCount", "true");
	        p.setProperty("reasonable", "true");
	        p.setProperty("returnPageInfo", "check");
	        p.setProperty("params", "count=countSql");
	        pageHelper.setProperties(p);
	        return pageHelper;
	    }
	 */

	/**
	 * @Title: roundRobinDataSouceProxy   
	 * @Description: 配置datasource切换，设置默认datasource和read的简单负载均衡 
	 * @return
	 * @return: AbstractRoutingDataSource
	 */
	@Bean(name="roundRobinDataSouceProxy")
	public AbstractRoutingDataSource roundRobinDataSouceProxy() {
	    	
	    	Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
	        // 把所有数据库都放在targetDataSources中,注意key值要和determineCurrentLookupKey()中代码写的一至，
	        // 否则切换数据源时找不到正确的数据源
	        targetDataSources.put(DataSourceTypeConstant.write.getType(), writeDataSource);
	        targetDataSources.put(DataSourceTypeConstant.read.getType()+"1", readDataSource01);
	        targetDataSources.put(DataSourceTypeConstant.read.getType()+"2", readDataSource02);
	        
	        // 路由类，寻找对应的数据源
	        AbstractRoutingDataSource proxy = new AbstractRoutingDataSource(){
	        	
	        	private AtomicInteger count = new AtomicInteger(0);
	        	/**
	             * 这是AbstractRoutingDataSource类中的一个抽象方法，
	             * 而它的返回值是你所要用的数据源dataSource的key值，有了这个key值，
	             * targetDataSources就从中取出对应的DataSource，如果找不到，就用配置默认的数据源。
	             */
	        	@Override
	        	protected Object determineCurrentLookupKey() {
	        		
	        		// 从当前线程变量local取出值来
	        		String typeKey = DataSourceContextHolder.getReadOrWrite();
	        		
	        		if(typeKey == null){
	        			throw new NullPointerException("数据库路由时，决定使用哪个数据库源类型不能为空...");
	        		}
	        		
	        		// 写库
	                if (typeKey.equals(DataSourceTypeConstant.write.getType())){
	                	System.err.println("使用数据库write.............");
	                    return DataSourceTypeConstant.write.getType();
	                }
	                	
	                //读库,多个, 简单负载均衡
	                int number = count.getAndAdd(1);
	                int lookupKey = number % readDataSourceSize;
	                System.out.println("使用数据库read-"+(lookupKey+1));
	                return DataSourceTypeConstant.read.getType()+(lookupKey+1);
	        	}
	        };
	        
	        proxy.setDefaultTargetDataSource(writeDataSource);//默认库
	        proxy.setTargetDataSources(targetDataSources);
	        
	        return proxy;
	 }
}
