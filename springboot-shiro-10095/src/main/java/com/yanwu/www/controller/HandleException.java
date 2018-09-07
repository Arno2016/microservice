/**  
 * All rights Reserved
 * @Title:  HandleException.java   
 * @Package com.yanwu.www.controller   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年8月30日 下午4:23:03   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.controller;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**   
 * @ClassName:  HandleException   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年8月30日 下午4:23:03   
 *     
 * @Copyright: 2018 
 */
@ControllerAdvice
public class HandleException {
	
	/**
	 * @Title: handleAuthorizationException   
	 * @Description: 授权异常  
	 * @param ae
	 * @return
	 * @return: String
	 */
	@ExceptionHandler(value=AuthorizationException.class)
	public String handleAuthorizationException(ServletRequest request, ServletResponse response,AuthorizationException ae){
		
		if(SecurityUtils.getSubject().getPrincipals() == null){
			System.out.println("用户未登录");
		}else{
			System.out.println("授权失败");
		}
		
		return ae.getMessage();
	}
	
	/**
	 * 
	 * @Title: handleAuthenticationException   
	 * @Description: 登录认证异常 
	 * @param ae
	 * @return
	 * @return: String
	 */
	@ExceptionHandler(value=AuthenticationException.class)
	public String handleAuthenticationException(AuthenticationException ae){
		
		System.out.println("认证失败");
		
		return ae.getMessage();
	}
}
