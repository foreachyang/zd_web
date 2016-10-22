package com.cn.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.component.RequestJsonParam;
import com.cn.pojo.Role_pojo;
import com.cn.service.Impl.RoleServiceImpl;

@Controller
@RequestMapping(value="admin_role")
public class RoleController {
	
     @Autowired(required=false)
     RoleServiceImpl roleservice;
     
	 @RequestMapping()
	 public String role(){
		 return "admin-role";
	 }
	 
	 @RequestMapping(value="role_add")
	 public String role_add(){
		  return "admin-role-add";
	 }
	 
	 

	 
}
