/**  
 * All rights Reserved
 * @Title:  UserServiceImpl.java   
 * @Package com.yanwu.www.service   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年9月4日 下午4:22:57   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.service;

import java.util.List;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yanwu.www.aop.ReadDataSource;
import com.yanwu.www.aop.WriteDataSource;
import com.yanwu.www.config.SpringUtil;
import com.yanwu.www.datasource.mapper.UserMapper;
import com.yanwu.www.domain.User;

/**   
 * @ClassName:  UserServiceImpl   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年9月4日 下午4:22:57   
 *     
 * @Copyright: 2018 
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	/**   
	 * <p>Title: queryAllUser</p>   
	 * <p>Description: </p>   
	 * @return   
	 * @see com.yanwu.www.service.UserService#queryAllUser()   
	 */
	@Override
	@ReadDataSource //读
	public List<User> queryAllUser() {
		
		List<User> users = userMapper.findAll();
		
		return users;
	}

	/**   
	 * <p>Title: addUser</p>   
	 * <p>Description: </p>   
	 * @param user
	 * @return   
	 * @see com.yanwu.www.service.UserService#addUser(com.yanwu.www.domain.User)   
	 */
	@Override
	@WriteDataSource //写
	public int addUser(User user) {
		
		int count = userMapper.addUser(user);
		
		// 调用内部方法无法走aop进行数据源的切换，需要额外处理
		List<User> users = getService().queryAllUser();
		
		System.out.println("============");
		//System.out.println(users.size());
		
		return count;
	}
	
	/**
	 * 
	 * @Title: getService   
	 * @Description: 获取bean，为了调用内部能进入aop 
	 * @return
	 * @return: UserService
	 */
	private UserService getService(){
		
		//return SpringUtil.getBean(UserService.class);
		return AopContext.currentProxy() != null ? (UserService)AopContext.currentProxy() : this;
	}
	
}
