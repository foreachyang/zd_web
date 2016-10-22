package com.cn.service.Impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.dao.UserDao;
import com.cn.pojo.User;
import com.cn.service.UserService;



@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	
	@Autowired
	private PasswordHelper password;
	
	public User getByUserName(String userName) {
		System.out.println("通过用户名查询用户");
		return userDao.getByUserName(userName);
	}

	public Set<String> getRoles(String userName) {
		System.out.println("通过用户名查询角色信息方法调用");
		return userDao.getRoles(userName);
	}

	public Set<String> getPermissions(String userName) {
		System.out.println("通过用户名查询权限信息");
		return userDao.getPermissions(userName);
	}

	public int createUser(User user) {
		System.out.println("创建用户");
		password.encryptPassword(user);
		
		int test= userDao.createUser(user);
		
		return test;
	}

}

