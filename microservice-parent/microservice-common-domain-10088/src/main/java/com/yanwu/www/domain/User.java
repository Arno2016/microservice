package com.yanwu.www.domain;
/**  
 * All rights Reserved
 * @Title:  User.java   
 * @Package com.yanwu.www.rest   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年7月11日 下午6:24:32   
 * @version V1.0 
 * @Copyright: 2018
 */


/**   
 * @ClassName:  User   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年7月11日 下午6:24:32   
 *     
 * @Copyright: 2018 
 */
public class User {
	private String id;
	private String name;
	private String age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
