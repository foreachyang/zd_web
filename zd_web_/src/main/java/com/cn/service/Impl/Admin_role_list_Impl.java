package com.cn.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cn.dao.Admin_role_listdao;
import com.cn.pojo.User;
import com.cn.service.Admin_role_listService;

@Service
public class Admin_role_list_Impl implements Admin_role_listService {
   
	@Autowired
	@Qualifier("admin_role_listdao")
	Admin_role_listdao  rolelist;
	public List<User> selectuser() {
	
		List<User> list = new ArrayList<User>();
		list= rolelist.selectuser();
		for (User user : list) {
			System.out.println("查询公司所有角色----------------------"+user.toString());
		}
		
		return list;
	}
	public List<String> select_sumadmin() {
		System.out.println("查询公司所有管理员----------------------");
		List<String> value= rolelist.select_sumadmin();
	   Long sum_value= value.stream().count();
	    System.out.println(sum_value);
	
		return null;
	}

}
