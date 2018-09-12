package com.yanwu.www.batch;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcBatchItemWriter;

import com.yanwu.www.domain.User;

/**
 * @ClassName:  MyFileWriter   
 * @Description: 处理process出来的数据  
 * @author: harvey
 * @date:   2018年9月10日 下午3:18:34   
 *     
 * @Copyright: 2018
 */
public class MyDBWriter extends JdbcBatchItemWriter<User> {
	
	public MyDBWriter(DataSource dataSource) {
		
		this.setDataSource(dataSource);
		
		
	}

	@Override
	public void write(List<? extends User> Users) throws Exception {
		
		for(User user : Users){
            System.out.println("=====MyDBWriter====>"+user);
        }
	}
	
}