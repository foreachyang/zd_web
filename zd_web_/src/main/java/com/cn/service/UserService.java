package com.cn.service;

import java.util.Set;

import com.cn.pojo.User;
public interface UserService {

	/**<P> 创建用户
	 * @param user 
	 */
	public int createUser(User user);
	
	
	/**
	 * 通过用户名查询用户
	 * @param userName
	 * @return
	 */
	public User getByUserName(String userName);
	
	/**
	 * 通过用户名查询角色信息
	 * @param userName
	 * @return
	 */
	public Set<String> getRoles(String userName);
	
	/**
	 * 通过用户名查询权限信息
	 * @param userName
	 * @return
	 */
	public Set<String> getPermissions(String userName);
}
