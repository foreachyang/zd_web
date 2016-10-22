package com.cn.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
/**
 * 
 * @author  周杰
 *  像界面显示当前登录用户
 */
@Entity 
public class User_pojo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "User_pojo [userName=" + userName + "]";
	}
	
	
 
}
