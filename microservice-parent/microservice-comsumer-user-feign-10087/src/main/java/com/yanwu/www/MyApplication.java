/**  
 * All rights Reserved
 * @Title:  MyApplication.java   
 * @Package com.yanwu.www   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年7月11日 下午5:12:59   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**   
 * @ClassName:  MyApplication   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年7月11日 下午5:12:59   
 *     
 * @Copyright: 2018 
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MyApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}
}
