package com.cn.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cn.pojo.Invoice_pojo;
import com.cn.pojo.Tables_pojo;
import com.cn.pojo.User;
import com.cn.service.InvoiceService;
import com.cn.service.Impl.Admin_role_list_Impl;

@RestController
public class TableController {
 
	 @Autowired  /*调用业务层bean*/
     InvoiceService invo;	
	
		@Autowired
		Admin_role_list_Impl rolelist;
	 
	 @RequestMapping(value="tables", produces="application/json")
	 public Map<String,List<Invoice_pojo>> test(Tables_pojo pojo) {
	    Map<String,List<Invoice_pojo>> map =  new HashMap<String, List<Invoice_pojo>>();
	    List<Invoice_pojo> list = new LinkedList<Invoice_pojo>();
	   list=invo.select_Invoice();
	   
      
	    map.put("data",list);
	   
	 System.out.println(map);
	 return map;
	 }
	 
	  @RequestMapping(value="select", produces="application/json")
	  public Map<String,List<User>> select_admin(User users){
		   List<User> list = new ArrayList<User>();
		  list= rolelist.selectuser();
		   System.out.println("admin role list-----------------------------------");
		  
		    Map<String,List<User>> map = new HashMap<String,List<User>>();
		    map.put("data",list);
		    
		    return map;
		    
		   
	  }
	  

	
}