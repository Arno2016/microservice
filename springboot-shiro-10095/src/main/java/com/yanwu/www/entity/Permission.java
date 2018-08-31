/**  
 * All rights Reserved
 * @Title:  Permission.java   
 * @Package com.yanwu.www.entity   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年8月30日 下午2:12:42   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**   
 * @ClassName:  Permission   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年8月30日 下午2:12:42   
 *     
 * @Copyright: 2018 
 */
@Entity
public class Permission {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    private String permission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
