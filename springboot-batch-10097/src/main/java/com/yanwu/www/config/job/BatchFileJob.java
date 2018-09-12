/**  
 * All rights Reserved
 * @Title:  BatchFileConfigure.java   
 * @Package com.yanwu.www.config   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年9月10日 下午1:49:24   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.config.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yanwu.www.batch.MyProcessor;
import com.yanwu.www.batch.MyFileReader;
import com.yanwu.www.batch.MyWriter;
import com.yanwu.www.domain.User;

/**   
 * @ClassName:  BatchFileConfigure   
 * @Description:构建job
 * @author: harvey
 * @date:   2018年9月10日 下午1:49:24   
 *     
 * @Copyright: 2018 
 */
@Configuration
@EnableBatchProcessing
public class BatchFileJob {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	/*创建job*/
    @Bean
    public Job job1(){
        return jobBuilderFactory.get("HarveyJob1")
                .start(stepMethod())  //构建job step步骤
                .listener(new JobListener()) //job执行监听，可以在各种状态监听
                .build();
    }

	/**   
	 * @Title: stepMethod   
	 * @Description: 构建step
	 * @return
	 * @return: Step
	 */
	private Step stepMethod() {
		
		 return stepBuilderFactory.get("step1")
	                .<User, User>chunk(3) //批处理每次提交3条数据
	                .reader(new MyFileReader())
	                .processor(new MyProcessor())
	                .writer(new MyWriter())
	                .allowStartIfComplete(true)
	                .build();
	}
	
}
