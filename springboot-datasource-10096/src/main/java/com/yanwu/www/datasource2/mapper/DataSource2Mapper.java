/**  
 * All rights Reserved
 * @Title:  DataSource1Mapper.java   
 * @Package com.yanwu.www.mapper   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年9月4日 下午1:46:27   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.datasource2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.yanwu.www.domain.User;

/**   
 * @ClassName:  DataSource1Mapper   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年9月4日 下午1:46:27   
 *     
 * @Copyright: 2018 
 */
public interface DataSource2Mapper {
	
	@Select("select * from user")
	List<User> findAllUser();
	
	@Insert("insert into user(username,password) values (#{username},#{password}) ")
	int insertUser(User user);
}
