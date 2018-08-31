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

import org.apache.shiro.authz.AuthorizationException;
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
	
	@ExceptionHandler(value=AuthorizationException.class)
	public String handleAuthorizationException(AuthorizationException ae){
		
		System.out.println("认证失败");
		
		return ae.getMessage();
	}
}
