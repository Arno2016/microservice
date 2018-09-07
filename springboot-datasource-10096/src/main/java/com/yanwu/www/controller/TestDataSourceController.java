/**  
 * All rights Reserved
 * @Title:  testDataSourceController.java   
 * @Package com.yanwu.www.controller   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年9月4日 下午1:51:00   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yanwu.www.datasource1.mapper.DataSource1Mapper;
import com.yanwu.www.datasource2.mapper.DataSource2Mapper;
import com.yanwu.www.domain.User;

/**   
 * @ClassName:  testDataSourceController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年9月4日 下午1:51:00   
 *     
 * @Copyright: 2018 
 */
//@RestController
public class TestDataSourceController {
	
	@Autowired
	private DataSource1Mapper dataSource1Mapper;
	
	@Autowired
	private DataSource2Mapper dataSource2Mapper;
	
	@RequestMapping(value="test1")
	public List<User> test1(){
		
		System.out.println("=========test datasource 1=========");
		
		List<User> users = dataSource1Mapper.findAllUser();
		
		return users;
	}
	
	@RequestMapping(value="test2")
	public List<User> test2(){
		
		System.out.println("=========test datasource 2=========");
		
		User user = new User();
		user.setUsername("test2");
		user.setPassword("test2");
		
		dataSource2Mapper.insertUser(user);
		
		List<User> users = dataSource2Mapper.findAllUser();
		
		return users;
	}
	
}
