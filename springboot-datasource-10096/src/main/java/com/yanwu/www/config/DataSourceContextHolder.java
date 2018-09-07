package com.yanwu.www.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
/**
 * 
 * @ClassName:  DataSourceContextHolder   
 * @Description:从本地线程获取数据源上下文
 * @author: harvey
 * @date:   2018年9月6日 下午2:39:49   
 *     
 * @Copyright: 2018
 */
public class DataSourceContextHolder {
 
	private static Logger log = LoggerFactory.getLogger(DataSourceContextHolder.class);
	
	//线程本地环境
	private static final ThreadLocal<String> local = new ThreadLocal<String>();
 
    public static ThreadLocal<String> getLocal() {
        return local;
    }
 
    /**
     * 读库
     */
    public static void setRead() {
        local.set(DataSourceTypeConstant.read.getType());
        log.info("数据库切换到读库...");
    }
 
    /**
     * 写库
     */
    public static void setWrite() {
        local.set(DataSourceTypeConstant.write.getType());
        log.info("数据库切换到写库...");
    }
 
    public static String getReadOrWrite() {
        return local.get();
    }
    
    public static void clear(){
    	local.remove();
    }
}