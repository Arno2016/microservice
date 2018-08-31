/**  
 * All rights Reserved
 * @Title:  UserController.java   
 * @Package com.yanwu.www.controller   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年8月30日 下午3:31:43   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yanwu.www.service.UserService;

/**   
 * @ClassName:  UserController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年8月30日 下午3:31:43   
 *     
 * @Copyright: 2018 
 */
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//登录
    @RequestMapping(value = "/login")
    public String login(String username,String password){
    	
    	String status = userService.login(username, password);
    	
        return status;
    }
    
    //首页
    @RequestMapping(value = "/index")
    public String index(){
    
        return "index";
    }
	
	//登出
    @RequestMapping(value = "/logout")
    public String logout(){
    	
    	userService.logout();
    	
        return "logout";
    }

    //错误页面展示
    @RequestMapping(value = "/error",method = RequestMethod.POST)
    public String error(){
        return "error ok!";
    }
    
    // 测试shiro注解
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @RequiresRoles(value={"admin"})
    public String test(){
        return "test ok!";
    }
    
    
}
