/**  
 * All rights Reserved
 * @Title:  UserServiceImpl.java   
 * @Package com.yanwu.www.service   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年8月30日 下午2:27:15   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.service;

import java.util.concurrent.TimeUnit;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**   
 * @ClassName:  UserServiceImpl   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年8月30日 下午2:27:15   
 *     
 * @Copyright: 2018 
 */
@Component
public class UserServiceImpl implements UserService {

	/**   
	 * <p>Title: login</p>   
	 * <p>Description: </p>   
	 * @param username
	 * @param password   
	 * @see com.yanwu.www.service.UserService#login(java.lang.String, java.lang.String)   
	 */
	@Override
	public String login(String username, String password) {
		
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
			throw new UnknownAccountException("账号或者密码为空");
		}
		
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
		
		Subject subject = SecurityUtils.getSubject();
		
		try{
			subject.login(usernamePasswordToken);
			
			// 设置闲置session时间
			subject.getSession().setTimeout(5*1000);
			return "login ok";
		}catch( AuthenticationException e){
			System.out.println("==========");
			System.out.println(e.getMessage());
		}
		
		return "login failure";

	}

	/**   
	 * <p>Title: logout</p>   
	 * <p>Description: </p>   
	 * @return   
	 * @see com.yanwu.www.service.UserService#logout()   
	 */
	@Override
	public String logout() {
		
		Subject subject = SecurityUtils.getSubject();
		
		subject.logout();
		
		return "logout ok";
	}
}
