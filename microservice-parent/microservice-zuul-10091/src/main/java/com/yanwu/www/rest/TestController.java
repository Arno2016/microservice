/**  
 * All rights Reserved
 * @Title:  TestController.java   
 * @Package com.yanwu.www.rest   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年7月11日 下午6:23:43   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yanwu.www.domain.User;

/**   
 * @ClassName:  TestController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年7月11日 下午6:23:43   
 *     
 * @Copyright: 2018 
 */
@RestController
public class TestController {
	
	/**
	 * @Title: testGet   
	 * @Description: 测试get方法
	 * @param reqUser
	 * @return: User
	 */
	@RequestMapping(value = "/testGetUser",method= RequestMethod.GET)
	public User testGet(User reqUser){
		System.out.println("入参=====>"+reqUser.toString());
		User user = new User();
		user.setAge("provider-get-age-12");
		user.setId("provider-get-id-12");
		user.setName("provider-get-name-user1");
		
		return user;
	} 
	
	/**
	 * @Title: testPost   
	 * @Description: 测试post方法
	 * @param reqUser
	 * @return: User
	 */
	@RequestMapping(value = "/testPostUser",method= RequestMethod.POST)
	public User testPost(@RequestBody User reqUser){
		System.out.println("入参=====>"+reqUser.toString());
		User user = new User();
		user.setAge("provider-post-age-12");
		user.setId("provider-post-id-12");
		user.setName("provider-post-name-user1");
		
		return user;
	} 
}
