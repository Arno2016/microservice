package com.yanwu.www.batch;

import org.springframework.batch.item.ItemProcessor;

import com.yanwu.www.domain.User;

/**
 * 
 * @ClassName:  MyFileProcessor   
 * @Description:创建spring batch的处理类，实现ItemProcessor接口，
 * 				覆写process方法，reader方法中读取一条记录放入User对象中，
 * 				在process方法中处理User对象
 * @author: harvey
 * @date:   2018年9月10日 下午1:44:57   
 *     
 * @Copyright: 2018
 */
public class MyProcessor implements ItemProcessor<User, User> {

    @Override
    public User process(User user) throws Exception {
    	
        if (Integer.parseInt(user.getAge()) % 2 == 0) {
            return user;
        }
        
        return null;
    }
}