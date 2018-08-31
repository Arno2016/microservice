/**  
 * All rights Reserved
 * @Title:  UserRealm.java   
 * @Package com.yanwu.www.config   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年8月30日 下午2:48:54   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.config;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yanwu.www.entity.Permission;
import com.yanwu.www.entity.Role;
import com.yanwu.www.entity.User;
import com.yanwu.www.repository.PermissionRipository;
import com.yanwu.www.repository.RoleRipository;
import com.yanwu.www.repository.UserRipository;

/**   
 * @ClassName:  UserRealm   
 * @Description: 自定义realm   
 * @author: harvey
 * @date:   2018年8月30日 下午2:48:54   
 *     
 * @Copyright: 2018 
 */
@Component
public class MyShiroRealm extends AuthorizingRealm{

	@Autowired
	private UserRipository userRipository;
	
	@Autowired
	private RoleRipository roleRipository;
	
	@Autowired
	private PermissionRipository permissionRipository;
	
	/**   
	 * <p>Title: doGetAuthorizationInfo</p>   
	 * <p>Description: </p>   
	 * @param arg0
	 * @return   
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)   
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		
		//获取登录用户名
        String username= (String) principalCollection.getPrimaryPrincipal();
        //查询用户名称
        User user = userRipository.findByName(username);
        
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        List<Role> roles = roleRipository.findRolesByUserId(user.getId().toString());
        for(Role role : roles){
        	// 添加角色
        	simpleAuthorizationInfo.addRole(role.getRoleName());
        	for(Permission permission : permissionRipository.findPermissionsByRoleId(role.getId().toString())){
        		// 添加权限
        		simpleAuthorizationInfo.addStringPermission(permission.getPermission());
        	}
        }
        
        return simpleAuthorizationInfo;
		
	}

	/**   
	 * <p>Title: doGetAuthenticationInfo</p>   
	 * <p>Description: </p>   
	 * @param arg0
	 * @return
	 * @throws AuthenticationException   
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)   
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		// 1.把AuthenticationToken转为UsernamePasswordToken对象
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;

		// 2.从UsernamePasswordToken获取username
		String userName = upToken.getUsername();

		// 3.调用数据库方法，从数据库中查询username对应的用户记录
		System.out.println("从数据库中获取信息userName:" + userName + "所对应信息");
		User user = userRipository.findByName(userName);
		
		// 4.若用户不存在，则可以抛出异常
		if (null == user) {
			throw new UnknownAccountException("用户不存在");
		}
		
		// 5.根据用户情况，来构建AuthenticationInfo对象并返回，通常使用的实现类是SimpleAuthenticationInfo
		
		// 1)principal,用户名,认证实体，可以是实体，也可以是数据表对应的实体类对象
		Object principal = userName;
		
		// 2)credential,密码,明文密码,即构建UsernamePasswordToken对象时的密码
		Object credentials = user.getPassword().toString();
		
		// 3)realmName：当前realm对象的name,调用父类的getName即可
		String realmName = getName();
		
		// 4.盐值(避免同一密码加密时产生相同的字符串,一般是用用户名做盐值)
		ByteSource credentialsSalt = ByteSource.Util.bytes(userName);

		// 不加密
		//SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realmName);
		
		// 加密
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(principal,credentials, credentialsSalt, realmName);

		return info;
	}
	
	
	// 增加用户时可以使用SimpleHash产生加密后的密码字符串存入数据库，避免数据库的用户密码明文显示
	public static void main(String[] args) {
		String algorithmName="MD5";
		Object source="1234";
		Object salt=ByteSource.Util.bytes("user2");
		int hashIterations=1024;
		Object result=new SimpleHash(algorithmName, source, salt, hashIterations);
		System.out.println(result);
	}

}
