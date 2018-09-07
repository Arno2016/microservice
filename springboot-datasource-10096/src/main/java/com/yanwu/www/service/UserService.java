/**  
 * All rights Reserved
 * @Title:  UserService.java   
 * @Package com.yanwu.www.service   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年9月4日 下午4:23:12   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.service;

import java.util.List;

import com.yanwu.www.domain.User;

/**   
 * @ClassName:  UserService   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年9月4日 下午4:23:12   
 *     
 * @Copyright: 2018 
 */
public interface UserService {
	
	List<User> queryAllUser();
	
	int addUser(User user);
}
