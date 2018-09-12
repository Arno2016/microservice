package com.yanwu.www.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.yanwu.www.domain.User;

/**
 * @ClassName:  MyFileWriter   
 * @Description: 处理process出来的数据  
 * @author: harvey
 * @date:   2018年9月10日 下午3:18:34   
 *     
 * @Copyright: 2018
 */
public class MyWriter implements ItemWriter<User> {
	
    @Override
    public void write(List<? extends User> Users) throws Exception {
    	
        for(User user : Users){
            System.out.println(user);
        }
    }
}