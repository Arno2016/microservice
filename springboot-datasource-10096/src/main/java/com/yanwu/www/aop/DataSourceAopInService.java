package com.yanwu.www.aop;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

import com.yanwu.www.config.DataSourceContextHolder;
import com.yanwu.www.config.DataSourceTypeConstant;
 
/**
 * @ClassName:  DataSourceAopInService   
 * @Description:在service层觉得数据源
 * 必须在事务AOP之前执行，所以实现Ordered,order的值越小，越先执行
 * 如果一旦开始切换到写库，则之后的读都会走写库
 * @author: harvey
 * @date:   2018年9月6日 下午2:23:59   
 *     
 * @Copyright: 2018
 */
@Aspect
@EnableAspectJAutoProxy(exposeProxy=true,proxyTargetClass=true)
@Component
public class DataSourceAopInService implements PriorityOrdered{
 
private static Logger log = LoggerFactory.getLogger(DataSourceAopInService.class);
	
	/*
	 
	 // 方法级别
	  
	@Before("execution(* com.yanwu.www.service..*.find*(..)) "
			+ " or execution(* com.yanwu.www.service..*.get*(..)) "
			+ " or execution(* com.yanwu.www.service..*.query*(..))")
    public void setReadDataSourceType() {
		//如果已经开启写事务了，那之后的所有读都从写库读
		if(!DataSourceType.write.getType().equals(DataSourceContextHolder.getReadOrWrite())){
			DataSourceContextHolder.setRead();
		}
        
    }
    @Before("execution(* com.yanwu.www.service..*.insert*(..)) "
    		+ " or execution(* com.yanwu.www.service..*.update*(..))"
    		+ " or execution(* com.yanwu.www.service..*.add*(..))")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.setWrite();
    }
    
    */
    
 
	@Before("execution(* com.yanwu.www.service..*.*(..)) "
			+ " and @annotation(com.yanwu.www.aop.ReadDataSource) ")
	public void setReadDataSourceType() {
		//如果已经开启写事务了，那之后的所有读都从写库读
		if(!DataSourceTypeConstant.write.getType().equals(DataSourceContextHolder.getReadOrWrite())){
			DataSourceContextHolder.setRead();
		}
	    
	}
	
	@Before("execution(* com.yanwu.www.service..*.*(..)) "
			+ " and @annotation(com.yanwu.www.aop.WriteDataSource) ")
	public void setWriteDataSourceType() {
	    DataSourceContextHolder.setWrite();
	}
    
	@Override
	public int getOrder() {
		/**
		 * 值越小，越优先执行
		 * 要优于事务的执行
		 * 在配置类中加上了@EnableTransactionManagement(order = 10) 
		 */
		return 1;
	}
 
}