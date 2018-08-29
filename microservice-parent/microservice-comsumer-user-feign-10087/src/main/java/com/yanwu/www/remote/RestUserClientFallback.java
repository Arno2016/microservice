/**  
 * All rights Reserved
 * @Title:  RestUserClientFallback.java   
 * @Package com.yanwu.www.remote   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年7月24日 下午11:20:53   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.remote;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.yanwu.www.domain.User;

/**   
 * @ClassName:  RestUserClientFallback   
 * @Description: RestUserClient失败回退方法
 * @author: harvey
 * @date:   2018年7月24日 下午11:20:53   
 * @Copyright: 2018 
 */
@Component
public class RestUserClientFallback implements RestUserClient{

	/**   
	 * <p>Title: testGet</p>   
	 * <p>Description:调用远程get方法失败回退</p>   
	 * @param reqMap
	 * @return   
	 * @see com.yanwu.www.remote.RestUserClient#testGet(java.util.Map)   
	 */
	@Override
	public User testGet(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setAge("fallback-get-age-01");
		user.setId("fallback-get--id-01");
		user.setName("fallback-get--name-01");
		return user;
	}

	/**   
	 * <p>Title: testPost</p>   
	 * <p>Description: 调用远程post方法失败回退</p>   
	 * @param reqUser
	 * @return   
	 * @see com.yanwu.www.remote.RestUserClient#testPost(com.yanwu.www.domain.User)   
	 */
	@Override
	public User testPost(User reqUser) {
		User user = new User();
		user.setAge("fallback-post-age-01");
		user.setId("fallback-post--id-01");
		user.setName("fallback-post--name-01");
		
		return user;
	}

}
