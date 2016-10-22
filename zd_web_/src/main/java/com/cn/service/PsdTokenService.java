package com.cn.service;

import com.cn.pojo.User;

/**
 * 
 * @author 周杰
 * <p> 从shiro 获取当前登录线程的密码
 *
 */
public interface PsdTokenService{
	 boolean check_password(String  password,String username, String salt,String md5);
	 public User  md5password(String username, String password);

}
