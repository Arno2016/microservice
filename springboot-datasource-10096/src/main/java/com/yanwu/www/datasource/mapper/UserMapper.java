/**  
 * All rights Reserved
 * @Title:  UserMapper.java   
 * @Package com.yanwu.www.datasource.mapper   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年9月4日 下午4:20:27   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.datasource.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.yanwu.www.domain.User;

/**   
 * @ClassName:  UserMapper   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年9月4日 下午4:20:27   
 *     
 * @Copyright: 2018 
 */
public interface UserMapper {
	
	@Select("select * from user")
	List<User> findAll();
	
	@Insert("insert into user(username,password) values (#{username},#{password}) ")
	int addUser(User user);
}
