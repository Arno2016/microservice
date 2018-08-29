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

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yanwu.www.domain.User;
import com.yanwu.www.remote.RestUserClient;

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
	
	@Autowired
	private RestUserClient restUserClient;
	
	@RequestMapping("/testGetUser")
	// 回退机制
	@HystrixCommand(fallbackMethod="fallback")
	public User testGet(){
		
		// get方法必须用map传递多参数
		/*User reqUser = new User();
		reqUser.setAge("comsumer-age-01");
		reqUser.setId("comsumer-id-01");
		reqUser.setName("comsumer-name-01");*/
		
		Map<String,Object> reqMap = new HashMap<String,Object>();
		reqMap.put("age", "get-comsumer-age-01");
		reqMap.put("id", "get-comsumer-id-01");
		reqMap.put("name", "get-comsumer-name-01");
		
		
		User user = restUserClient.testGet(reqMap);
		
		return user;
	} 
	
	@RequestMapping("/testPostUser")
	// 回退机制
	@HystrixCommand(fallbackMethod="fallback")
	public User testPost(){
		
		User reqUser = new User();
		reqUser.setAge("post-comsumer-age-02");
		reqUser.setId("post-comsumer-id-02");
		reqUser.setName("post-comsumer-name-02");
		
		User user = restUserClient.testPost(reqUser);
		
		return user;
	} 
	
	/**
	 * @Title: fallback   
	 * @Description: 回退方法
	 * @param reqUser
	 * @return
	 * @return: User
	 */
	private User fallback(){
		User user = new User();
		user.setAge("fallback--age-01");
		user.setId("fallback--id-01");
		user.setName("fallback--name-01");
		return user;
	}
}
