/**  
 * All rights Reserved
 * @Title:  TestControll.java   
 * @Package com.yanwu.www.rest   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年8月29日 下午10:41:09   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**   
 * @ClassName:  TestControll   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年8月29日 下午10:41:09   
 *     
 * @Copyright: 2018 
 */
@RestController
public class TestController {
	
	@Value("${env}")
    private String env;
    
	@RequestMapping(value = "/test")
	public String test(){
		return env;
	}
}
