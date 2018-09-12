/**  
 * All rights Reserved
 * @Title:  Snippet.java   
 * @Package com.yanwu.www.config.file   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年9月11日 下午8:52:52   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.config.job;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**   
 * @ClassName:  Snippet   
 * @Description: job定时启动,或者调用url启动 
 * @author: harvey
 * @date:   2018年9月11日 下午8:52:52   
 *     
 * @Copyright: 2018 
 */
@RestController
@EnableScheduling
public class JobScheduleController {
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Resource(name="job1")
	private Job job1; 
	
	@Resource(name="job2")
	private Job job2;  
	  
	@Scheduled(cron="*/40 * * * * ? ")  
	@RequestMapping("/testJob1")
	public void run(){  
	    try {  
	    	System.out.println("=======这是job1==========");
	    	
	    	// job参数
	    	JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
	    	jobParametersBuilder.addDate("date", new Date());
	        JobExecution execution = jobLauncher.run(job1, jobParametersBuilder.toJobParameters());
	        
	        System.out.println("Execution status: "+ execution.getStatus());  
	    } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException  
	            | JobParametersInvalidException e) {  
	        e.printStackTrace();  
	    }   
	}  
	
	@Scheduled(cron="*/3 * * * * ? ")  
	public void run2(){  
	    try {  
	    	System.out.println("=======这是job2==========");
	        JobExecution execution = jobLauncher.run(job2, new JobParameters());  
	        System.out.println("Execution status: "+ execution.getStatus());  
	    } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException  
	            | JobParametersInvalidException e) {  
	        e.printStackTrace();  
	    }   
	} 
}

