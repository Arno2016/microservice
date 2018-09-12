/**  
 * All rights Reserved
 * @Title:  User.java   
 * @Package com.yanwu.www.domain   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: harvey 
 * @date:   2018年9月10日 下午1:25:47   
 * @version V1.0 
 * @Copyright: 2018
 */
package com.yanwu.www.domain;

/**   
 * @ClassName:  User   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: harvey
 * @date:   2018年9月10日 下午1:25:47   
 *     
 * @Copyright: 2018 
 */
public class User {

	private String id;
	
	private String name;
	
	private String age;
	
	public User(){
		
	}

	/**   
	 * @Title:  User   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:  @param readString
	 * @param:  @param readString2
	 * @param:  @param readString3  
	 * @throws   
	 */
	public User(String id,String name,String age) {
		this.id= id;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	

}
