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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
	
	private static Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private RestUserClient restUserClient;
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/testGetUser")
	public User testGet(){
		logger.info("调用provider user ------------");
		// get方法必须用map传递多参数
		/*User reqUser = new User();
		reqUser.setAge("comsumer-age-01");
		reqUser.setId("comsumer-id-01");
		reqUser.setName("comsumer-name-01");*/
		
		// restTemplate.getForEntity("http://provider-user/testGetUser",String.class).getBody();
		
		Map<String,Object> reqMap = new HashMap<String,Object>();
		reqMap.put("age", "get-comsumer-age-01");
		reqMap.put("id", "get-comsumer-id-01");
		reqMap.put("name", "get-comsumer-name-01");
		
		
		User user = restUserClient.testGet(reqMap);
		
		return user;
	} 
	
	@RequestMapping("/testPostUser")
	public User testPost(){
		
		User reqUser = new User();
		reqUser.setAge("post-comsumer-age-02");
		reqUser.setId("post-comsumer-id-02");
		reqUser.setName("post-comsumer-name-02");
		
		User user = restUserClient.testPost(reqUser);
		
		return user;
	} 
}
