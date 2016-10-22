package com.cn.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * @author 周杰
 *  全局异常捕获  service dao  controller 
 */
/*
import net.sf.json.JSONObject;  
@Controller
@RequestMapping(value="exception")
public class HandlerExceptionResolver_Controller implements HandlerExceptionResolver {

	//Logger log;
	boolean flag=true;
	
	@RequestMapping()
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception es) {
	
		 System.out.println("全局异常处理");
		 System.out.println("exception--------------------------------"+es.toString());
		 if(es instanceof org.apache.shiro.authz.HostUnauthorizedException){
			 System.out.println("UnauthorizedException 捕获--------------------------------------------------");
			 
			  
			 
			 return  new ModelAndView("noauthroized");

		 }
		 else if(es instanceof org.apache.shiro.authz.AuthorizationException){
			 System.out.println("AnauthorizedException 捕获--------------------------------------------------");
		  return  new ModelAndView("404");
		 }
		 else if(es instanceof org.apache.shiro.authc.UnknownAccountException){
		//	 log.info("进入了管理员登录页面 并且登录发生了失败");
			 System.out.println("UnknownAccountException 捕获--------------------------------------------------");
			 flag=false;
			 unexcep();
		  return  new ModelAndView("404");
		 }
		 
		 
		 return  new ModelAndView();
	}
	
	@RequestMapping("un")
	@ResponseBody
 private Map unexcep(){
	  System.out.println("账户密码为空处理方法");
   Map<String,String> map = new HashMap<String,String>();
   
     if (flag)map.put("msg","true");
     
     else map.put("msg", "false"); 
     System.out.println("标志位归为true");
     flag=true;
     return map;
}
 
 
}
*/
