/**  
 * All rights Reserved
 * @Title:  UserRole.java   
 * @Package com.yanwu.www.entity   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年8月30日 下午2:15:24   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**   
 * @ClassName:  UserRole   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年8月30日 下午2:15:24   
 *     
 * @Copyright: 2018 
 */
@Entity
public class UserRole {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String userId;
	
	private String roleId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
