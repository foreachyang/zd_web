package com.cn.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cn.dao.Member_productdao;
import com.cn.dao.Memberdao;
import com.cn.pojo.Member_product_pojo;
import com.cn.service.MemberService;
import com.cn.service.Member_productService;

@Service
public class Member_productService_Impl implements Member_productService{

	@Autowired
	@Qualifier("member_productdao")
	Member_productdao memberdao;
	
	public int Insert_member_product(Member_product_pojo member) {
		
		int i= memberdao.Insert_member_product(member);
		return i;
	}

}
