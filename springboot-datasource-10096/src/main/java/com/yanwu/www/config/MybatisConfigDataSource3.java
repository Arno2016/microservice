/**  
 * All rights Reserved
 * @Title:  MybatisConfig.java   
 * @Package com.yanwu.www.config   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   3018年9月4日 下午1:33:53   
 * @version V1.0 
 * @Copyright: 3018
 */
package com.yanwu.www.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**   
 * @ClassName:  MybatisConfig   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   3018年9月4日 下午1:33:53   
 *     
 * @Copyright: 3018 
 */
//@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.yanwu.www.datasource3.mapper"}, sqlSessionTemplateRef = "sqlSessionTemplate3")
public class MybatisConfigDataSource3 {
	
	@Bean(name = "dataSource3")
	//必须加此注解，不然报错，下一个类则不需要添加
    //@Primary 
    // prefix值必须是application.properteis中对应属性的前缀
    @ConfigurationProperties(prefix = "spring.datasource3") 
    public DataSource userDataSource() {
        return DataSourceBuilder.create().build();
    }
	
	@Bean
	public SqlSessionFactory sqlSessionFactory3(@Qualifier("dataSource3") DataSource dataSource) throws Exception {

		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		// 添加XML目录
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			// bean.setMapperLocations(resolver.getResources("classpath*:com/user/server/dao/mapping/*.xml"));
			return bean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	    
	    @Bean
	    public SqlSessionTemplate sqlSessionTemplate3(@Qualifier("sqlSessionFactory3") SqlSessionFactory sqlSessionFactory) throws Exception {
	        
	    	SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
	    	
	        return template;
	    }
	
	
	
}
