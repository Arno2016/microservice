/**  
 * All rights Reserved
 * @Title:  User.java   
 * @Package com.yanwu.www.domain   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年9月4日 下午1:49:47   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.domain;

/**   
 * @ClassName:  User   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年9月4日 下午1:49:47   
 *     
 * @Copyright: 2018 
 */
public class User {
	private int id;
	private String username;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
