package com.yanwu.www.config.job;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

/**
 * @ClassName:  JobCompletionListener   
 * @Description: 监听batch job执行链
 * @author: harvey
 * @date:   2018年9月10日 下午3:19:43   
 *     
 * @Copyright: 2018
 */
public class JobListener extends JobExecutionListenerSupport {
	
	
    //job开始之前
    @Override
	public void beforeJob(JobExecution jobExecution) {
    	
        System.out.println("=========BATCH JOB START SUCCESSFULLY=========");
   
	}
    
    //job结束之后
	@Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            System.out.println("=========BATCH JOB COMPLETED SUCCESSFULLY=========");
        }
    }
    
}