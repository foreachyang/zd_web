package com.cn.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.component.RequestJsonParam;
import com.cn.pojo.Staff_pojo;
import com.cn.pojo.Tables_pojo;
import com.cn.pojo.User;
import com.cn.pojo.User_pojo;
import com.cn.service.Impl.NetworkUtil;
import com.cn.service.Impl.SequenceGenerator;
import com.cn.service.Impl.StaffService_Impl;
import com.cn.service.Impl.UserServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
@RequestMapping("user")
public class LoginController {

	 private String staff_user;
		
	 @Autowired(required=false)
	 NetworkUtil  util;
	 
	 @Autowired(required=false)
	 UserServiceImpl userImpl;
	
	 @Autowired(required=false)
	 StaffService_Impl staff;
	 
	 @Autowired(required=false)
	 SequenceGenerator  seq;
		
	@RequestMapping(value="index")
	public String idnex(){return "index";}
	
    
	@RequestMapping(value="login", produces="application/json",method=RequestMethod.POST)
	@ResponseBody
   public Map<String,Object> login(@RequestJsonParam(value="model")User user, HttpServletRequest request) throws IOException {
		  String ip = NetworkUtil.getIpAddress(request);
		  System.out.println("login   ip"+ip);
		 System.out.println("login   toString"+user.toString());
		 System.out.println("普通员工登录-------------------------------------------");
     Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token= new UsernamePasswordToken(user.getUserName(),user.getPassword());
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		 
		
		try {
		subject.login(token);
		
		Session session=subject.getSession(true);
		
		staff_user=user.getUserName();
		map.put("errormsg",null);
	return map;
	} catch (UnauthorizedException e) {
		map.put("errormsg","错误");
		 e.printStackTrace();		
		 return map;
		
		 
	}catch(IncorrectCredentialsException e){
		map.put("errormsg","错误");
		  throw new IncorrectCredentialsException();
	}catch(UnknownAccountException e){
		map.put("errormsg","错误");
		  throw new UnknownAccountException();
	}catch(Exception e){
		try {
			map.put("errormsg","错误");
			throw new Exception();
		} catch (java.lang.Exception e1) {
			map.put("errormsg","错误");
			e1.printStackTrace();
		}
	}	
	return map;
		
	}
	
	@RequestMapping(value="staff")
	public String  staff(){
		 return "staff";
	}
	
	@RequestMapping(value="staff_value",produces="application/json")
	@ResponseBody
	public JSONObject staff_value(){

	  
	  JSONObject jsono = new JSONObject();
	   jsono.put("username",staff_user);
	  
	   JSONArray jsonArray = new JSONArray();
	   jsonArray.add(jsono);
	   
	   jsono.element("people", jsonArray);
	   staff_user=null;
	  return jsono;
	}
	
	
@RequestMapping(value="test",produces="application/json")
@ResponseBody
public JSONObject test() {
	System.out.println("test------------------------------------");
	User_pojo user = new User_pojo();
	user.setUserName("zhoujie");


 JSONObject jsonobject = new JSONObject();
 jsonobject.put("userName",user.getUserName());

 
 JSONArray jsonArray = new JSONArray();
 jsonArray.add(jsonobject);
 
 jsonobject.element("people", jsonArray);
 
 return jsonobject;
}

}
