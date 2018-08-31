/**  
 * All rights Reserved
 * @Title:  UserService.java   
 * @Package com.yanwu.www.service   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年8月30日 下午2:25:11   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.service;

import org.springframework.stereotype.Service;

/**   
 * @ClassName:  UserService   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年8月30日 下午2:25:11   
 *     
 * @Copyright: 2018 
 */
public interface UserService {
	/**
	 * 
	 * @Title: login   
	 * @Description: 用户登录   
	 * @param username
	 * @param password
	 * @return
	 * @return: String
	 */
	String login(String username,String password);
	
	/**
	 * 
	 * @Title: logout   
	 * @Description: 用户登出   
	 * @return
	 * @return: String
	 */
	String logout();
}
