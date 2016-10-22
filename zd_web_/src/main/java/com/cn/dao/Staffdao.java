package com.cn.dao;

import java.util.List;

import com.cn.pojo.Staff_pojo;

public interface Staffdao {
  
	public List<Staff_pojo> select_staff(String username);
	public int insert_staff(Staff_pojo staff);
}
