/**  
 * All rights Reserved
 * @Title:  MyDBReader.java   
 * @Package com.yanwu.www.batch   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年9月12日 上午9:13:03   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.batch;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.yanwu.www.domain.User;

/**   
 * @ClassName:  MyDBReader   
 * @Description: 从数据库中读取内容
 * @author: harvey
 * @date:   2018年9月12日 上午9:13:03   
 *     
 * @Copyright: 2018 
 */
public class MyDBReader extends JdbcCursorItemReader<User>{
	
	
	public MyDBReader(DataSource dataSource){
		
		// 设置数据源
		this.setDataSource(dataSource);
		
		// 设置sql
		this.setSql("select id,name,age from user");
		
		// 设置字段和对象的属性对应，返回对象
		this.setRowMapper(new BeanPropertyRowMapper<>(User.class));
	}

}
