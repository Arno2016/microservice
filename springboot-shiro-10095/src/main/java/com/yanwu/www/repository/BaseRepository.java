package com.yanwu.www.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
/**
 * 
 * @ClassName:  BaseRepository   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年8月30日 下午2:21:18   
 *   
 * @param <T>
 * @param <I>  
 * @Copyright: 2018
 */
@NoRepositoryBean
public interface BaseRepository<T,I extends Serializable> extends PagingAndSortingRepository<T,I>,JpaSpecificationExecutor<T>{

}