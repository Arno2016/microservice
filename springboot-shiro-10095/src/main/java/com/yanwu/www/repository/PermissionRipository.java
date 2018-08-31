/**  
 * All rights Reserved
 * @Title:  UserRipository.java   
 * @Package com.yanwu.www.repository   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年8月30日 下午2:20:19   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yanwu.www.entity.Permission;

/**   
 * @ClassName:  UserRipository   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年8月30日 下午2:20:19   
 *     
 * @Copyright: 2018 
 */
@Repository
public interface PermissionRipository extends BaseRepository<Permission, Long>{
	
	@Query(value = "select distinct p.*  from permission p  inner join role_permission rp on rp.permission_id = p.id inner join role r on r.id = rp.role_id  where r.id =?1" ,nativeQuery=true)
	List<Permission> findPermissionsByRoleId(String roleId);
}
