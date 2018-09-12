package com.yanwu.www.batch;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.validation.BindException;

import com.yanwu.www.domain.User;

/**
 * 
 * @ClassName:  MyFileReader   
 * @Description: 从文件中读取内容
 * @author: harvey
 * @date:   2018年9月10日 下午3:13:54   
 *     
 * @Copyright: 2018
 */
public class MyFileReader extends FlatFileItemReader<User> {
	
    public MyFileReader(){
        createReader();
    }

    private void createReader(){
    	// 文件位置
        this.setResource(new ClassPathResource("User.txt"));
        // 跳过的行数
        this.setLinesToSkip(1);
        // 设置出来每行数据的映射
        this.setLineMapper(userLineMapper());
    }

    private LineMapper<User> userLineMapper(){
    	
        DefaultLineMapper<User> lineMapper = new DefaultLineMapper<>();
        // 字段分割
        lineMapper.setLineTokenizer(userLineTokenizer());
        // 将读出来的数据封装到对象
        lineMapper.setFieldSetMapper(new UserFieldStepMapper());
        
        lineMapper.afterPropertiesSet(); 
        
        return lineMapper;
    }
    
    //文件分割
    private LineTokenizer userLineTokenizer(){
    	// 设置分割符,默认逗号分割
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        // 设置每一列的名字，后面根据这个获取数据
        tokenizer.setNames(new String[]{"ID", "NAME", "AGE"});
        return tokenizer;
    }
    
    // 将数据封装到对象
    private static class UserFieldStepMapper implements FieldSetMapper<User>{
    	
        @Override
        public User mapFieldSet(FieldSet fieldSet) throws BindException {
            
        	return new User(fieldSet.readString("ID"), 
                    fieldSet.readString("NAME"), 
                    fieldSet.readString("AGE"));
        }

    }
}