/**  
 * All rights Reserved
 * @Title:  DataSourceConfig.java   
 * @Package com.yanwu.www.config   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年9月4日 下午4:00:18   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**   
 * @ClassName:  DataSourceConfig   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年9月4日 下午4:00:18   
 *     
 * @Copyright: 2018 
 */
@Configuration
public class DataSourceConfig {
	
	@Bean(name = "writeDataSource")
	//必须加此注解，不然报错，下一个类则不需要添加
    @Primary 
    // prefix值必须是application.properteis中对应属性的前缀
    @ConfigurationProperties(prefix = "spring.datasource1") 
    public DataSource dataSource1() {
		System.out.println("==========spring.datasource1============");
        return DataSourceBuilder.create().build();
    }
	
	@Bean(name = "readDataSource01")
    @ConfigurationProperties(prefix = "spring.datasource2") 
    public DataSource dataSource2() {
		System.out.println("==========spring.datasource2============");
        return DataSourceBuilder.create().build();
    }
	
	@Bean(name = "readDataSource02")
    @ConfigurationProperties(prefix = "spring.datasource3") 
    public DataSource dataSource3() {
		System.out.println("==========spring.datasource3============");
        return DataSourceBuilder.create().build();
    }
}
