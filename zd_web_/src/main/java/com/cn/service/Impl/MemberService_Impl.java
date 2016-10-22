package com.cn.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cn.dao.Memberdao;
import com.cn.pojo.Member_pojo;
import com.cn.pojo.User;
import com.cn.service.MemberService;

@Service
public class MemberService_Impl implements MemberService{

	 @Autowired
	 @Qualifier("memberdao")
	 Memberdao member;
	 
	 public List<User> select_usersync(String user){
		   List<User> list = new ArrayList<User>();
		   list=this.member.select_usersync(user);
		   
		   for(User users : list){
			    System.out.println("member 服务层-----------------"+users.toString());
		   }
		   
		    return list;
		   
	 }
	
	public int insert_member(Member_pojo member) {
		
		this.member.insert_member(member);
		
		return 0;
	}

	public List<Member_pojo> selectmember() {
		 List<Member_pojo> list = new ArrayList<Member_pojo>();
		 
		 list=this.member.selectmember();
		 
		 for(Member_pojo member :list) System.out.println("查询公司所有客户 service"+member.toString());
		return list;
	}

}
