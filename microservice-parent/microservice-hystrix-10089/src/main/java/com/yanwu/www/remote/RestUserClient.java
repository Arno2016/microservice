/**  
 * All rights Reserved
 * @Title:  TestInterface.java   
 * @Package com.yanwu.www.remote   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年7月11日 下午6:56:30   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.remote;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yanwu.www.domain.User;

/**   
 * @ClassName:  TestInterface   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年7月11日 下午6:56:30   
 *     
 * @Copyright: 2018 
 */
@FeignClient(value = "provider-user")
public interface RestUserClient {
	

	@RequestMapping(value = "/testGetUser",method= RequestMethod.GET)
	User testGet(@RequestParam Map<String,Object> reqMap);
	
	@RequestMapping(value = "/testPostUser",method= RequestMethod.POST)
	User testPost(@RequestBody User reqUser);
	
}
