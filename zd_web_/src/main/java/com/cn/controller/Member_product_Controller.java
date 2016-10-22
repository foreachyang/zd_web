package com.cn.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cn.component.RequestJsonParam;
import com.cn.pojo.Member_product_pojo;
import com.cn.service.Impl.Member_productService_Impl;
import com.cn.service.Impl.SequenceGenerator;

@Controller
public class Member_product_Controller {
	 
	  @Autowired(required=false)
	  Member_productService_Impl  member;
	
	   @Autowired(required=false)
	   SequenceGenerator seq;
	@RequestMapping(value="add_product", produces="application/json", method=RequestMethod.POST)
	@ResponseBody()
	public Map<String,Object> add_product(@RequestJsonParam(value="model") Member_product_pojo member_pojo){
		    Map<String,Object> map = new HashMap<String,Object>();
		  //  member_pojo.setId(seq.nextproduct_seq());
		   System.out.println(member_pojo.toString());
		   
		 //  int i= member.Insert_member_product(member_pojo);
		      
		      map.put("user", member_pojo.getMember_name());
		      map.put("yaopin", member_pojo.getMember_product());
		      map.put("sl", member_pojo.getMember_s());
		      map.put("msg", "已提交");
		      
		      return map;
		
	}

}
