package com.cn.service;

import java.util.List;

import com.cn.pojo.Member_pojo;
import com.cn.pojo.User;

public interface MemberService {
	 public int insert_member(Member_pojo member);
	 public List<User> select_usersync(String user);
	  public List<Member_pojo> selectmember();
}
