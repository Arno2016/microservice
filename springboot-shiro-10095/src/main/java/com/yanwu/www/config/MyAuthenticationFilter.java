/**  
 * All rights Reserved
 * @Title:  MyAuthenticationFilter.java   
 * @Package com.yanwu.www.config   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年9月7日 上午9:33:34   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.config;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;

/**   
 * @ClassName:  MyAuthenticationFilter   
 * @Description:自定义认证拦截器   
 * @author: harvey
 * @date:   2018年9月7日 上午9:33:34   
 *     
 * @Copyright: 2018 
 */
public class MyAuthenticationFilter extends AuthenticationFilter{

	/**   
	 * <p>Title: onAccessDenied</p>   
	 * <p>Description:shiro 登入认证拦截器 </p>   
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception   
	 * @see org.apache.shiro.web.filter.AccessControlFilter#onAccessDenied(javax.servlet.ServletRequest, javax.servlet.ServletResponse)   
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		Subject subject = getSubject(request, response);
		if(subject.getPrincipal() == null){
			return true;
		}
		
		return false;
	}

}
