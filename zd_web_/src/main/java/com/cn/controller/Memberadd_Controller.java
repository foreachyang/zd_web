package com.cn.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.component.RequestJsonParam;
import com.cn.pojo.Member_pojo;
import com.cn.service.Impl.MemberService_Impl;
import com.cn.service.Impl.SequenceGenerator;

@Controller
public class Memberadd_Controller {

	
	 @Autowired
	 MemberService_Impl memberservice;
	 
	 @Autowired
	 SequenceGenerator seq;
	
	  @RequestMapping(value="member_adds", produces={"text/html;charset=UTF-8;","application/json;"})
      @ResponseBody
	    public Map<String,Object> member_add(@RequestJsonParam(value="model",required=true) Member_pojo member){
	     Map<String,Object> map = new HashMap<String,Object>();
	   
	    	    member.setCellphonenumber(123456);
	    	      System.out.println("ok ok ok ");
	    	    member.setCompany("xx药店");
	    	    member.setGender("男");
	    	    member.setCustomername("刘欣");
	    	    member.setMailbox("614573257@qq.com");
	    	    member.setStaff("admin");
	    	    member.setSync("0");
	    	     member.setId(seq.nextmember_seq());
	   
	    	   System.out.println("member_add--------------------"+member.toString());      
	    	   memberservice.select_usersync(member.getStaff());
	    	   memberservice.insert_member(member);
	    	   
	    	 map.put("msg",null);
	    	   
	    	   return  map;
	    }
}
