/**  
 * All rights Reserved
 * @Title:  TestWriteOrReadController.java   
 * @Package com.yanwu.www.controller   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年9月4日 下午4:22:21   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yanwu.www.domain.User;
import com.yanwu.www.service.UserService;

/**   
 * @ClassName:  TestWriteOrReadController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年9月4日 下午4:22:21   
 *     
 * @Copyright: 2018 
 */
@RestController
public class TestWriteOrReadController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="testRead")
	public List<User> testRead(){
		
		List<User> users = userService.queryAllUser();
		
		return users;
	}
	
	@RequestMapping(value="testWrite")
	public int testWrite(){
		
		User user = new User();
		user.setUsername("testWrite");
		user.setPassword("testWrite");
		
		int count =  userService.addUser(user);
		
		return count;
	}
	
}
