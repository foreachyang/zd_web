package com.cn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.component.RequestJsonParam;
import com.cn.pojo.Member_pojo;
import com.cn.pojo.User;
import com.cn.service.Impl.MemberService_Impl;
import com.cn.service.Impl.SequenceGenerator;

@Controller
@RequestMapping(value="member")
public class Member_Controller {
          
	 @Autowired(required=false)
	 MemberService_Impl memberservice;
	 
	 @Autowired(required=false)
	 SequenceGenerator seq;
	
	@RequestMapping()
	public String defualt(){
		return "member-list";
	}
	
	@RequestMapping(value="member_view")
	public String memberber(){
		return "member-add";
	}
	
	
	@RequestMapping(value="member_product")
	public String member_product(){return "member-product";}
	@RequestMapping(value="select_member",produces="application/json")
	@ResponseBody()
	public Map<String,List<Member_pojo>> select_member(@RequestJsonParam(value="model",required=true) Member_pojo member){
		  System.out.println("select  member"+member.toString());
		  List<Member_pojo> list= memberservice.selectmember();
		  Map<String, List<Member_pojo>> map = new HashMap<String, List<Member_pojo>>();
		  map.put("data", list);
		return  map;
		  
	}
	
	
	
    @RequestMapping(value="member_adds"/*, produces={"text/html;charset=UTF-8;","application/json;"}/*, method=RequestMethod.POST*/)

    public String member_add(@RequestJsonParam(value="model",required=true) Member_pojo member){
    	//  Map<String,Object> map = new HashMap<String,Object>();
    	    member.setCellphonenumber(123456);
    	     
    	    member.setCompany("s");
    	    member.setGender("t");
    	    member.setCustomername("d");
    	    member.setMailbox("s");
    	    member.setStaff("admin");
    	    member.setSync("0");
    	     member.setId(seq.nextmember_seq());
    	   System.out.println("member_add--------------------"+member.toString());  
    	   
    	   User user = new User();
    
    	   memberservice.select_usersync(member.getStaff());
    	   memberservice.insert_member(member);
    	   
    	 //  map.put("msg",null);
    	   
    	   return "ok";
    }
}
