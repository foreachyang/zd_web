package com.cn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cn.component.RequestJsonParam;

import com.cn.pojo.Role_pojo;
import com.cn.pojo.User;
import com.cn.pojo.User_pojo;
import com.cn.service.Impl.Admin_role_list_Impl;
import com.cn.service.Impl.SequenceGenerator;
import com.cn.service.Impl.SystemLogoutFilter;
import com.cn.service.Impl.UserServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller()
@RequestMapping(value="admin")
public class Admin_indexController {

	@Autowired(required=false)
	UserServiceImpl userimpl;
	
	@Autowired(required=false)
	SequenceGenerator seq;  
	
   @Autowired(required=false)
   SystemLogoutFilter systemout;
	
   @Autowired(required=false)
   Admin_role_list_Impl admin_role;
   
	private boolean flag=true;
  private String username;


  
  @RequestMapping(value="UnauthorizedException")
  public String  unexception(){
	  return "noauthroized";
  }
  
  @RequestMapping(value="logout")
  public String logout(){
	  System.out.println("管理员退出"); 
	   SecurityUtils.getSubject().logout();
	   
	   return "redirect:http://localhost:8080/zd_web_";
  }

	 @RequestMapping()
	 public String index() {
		       
		 return "login";
	 }
	
	//@RequiresRoles(value={"admin"})
	 @RequestMapping(value="user_admin")
	 public String index_admin(HttpServletResponse response){
		 response.setHeader("Cache-Control","no-store");
		 response.setHeader("Pragrma","no-cache");
		 response.setDateHeader("Expires",0);
		 
		 Subject subject = SecurityUtils.getSubject();
		   System.out.println("jin ru index admin----------------------------");
		  
		 subject.checkRole("admin");
		 
	
		 return "index_admin";
	 }
	 
	 
	@RequestMapping(value="login" , produces="application/json")
	@ResponseBody()
	public Map<String, Object> login(@RequestJsonParam(value="model",required=true) User user_admin)throws UnauthorizedException{
	      System.out.println("进入login方法------------------------------------------------");
		  if(user_admin.getUserName()==null||user_admin.getUserName()==" " ||user_admin.getUserName()=="")
			                System.out.println("当前登录的管理员 为空");
				Map<String,Object> map = new HashMap<String,Object>();
				try{
				UsernamePasswordToken token = new UsernamePasswordToken(user_admin.getUserName(),user_admin.getPassword());	
				System.out.println("login user"+user_admin.toString());
			SecurityUtils.getSubject().login(token);
				
			 Subject subject = SecurityUtils.getSubject();	
	      
              subject.checkRole("admin");
				}catch(org.apache.shiro.authc.UnknownAccountException e){
					 map.put("message", "账号或密码为空");
				}
					System.out.println("admin   login"+user_admin.getUserName()); 
	
				 this.username=user_admin.getUserName();
				 map.put("message", null);
				
				return map;
	}
	 /**
	  * 
	  * @param user_admin
	  *    创建管理员用户 默认Roleid    默认为admin 角色 默认不锁定账号
	  * @return
	  */
	 @RequestMapping(value="admin_add", produces="application/json")
      @ResponseBody()
	 public Map<String,Object> add(@RequestJsonParam(value="model",required=true) User user_admin){
		 
		
		  user_admin.setId(seq.nextRechargeOrderseq());
		  user_admin.setRoleid(2);  
		  user_admin.setSync(0);
		   
		 
		   System.out.println(user_admin.toString()); 
		 Map<String,Object> map = new HashMap<String,Object>();
	  
		userimpl.createUser(user_admin);
	  map.put("msg", "创建成功");
  
		  return  map;
	 }
	 
	 /**
	  *  当前用户   responsebody json
	  */
	 @RequestMapping(value="welcome_admin" ,produces="application/json")
	 @ResponseBody
	 public JSONObject welcome(User_pojo user){
		 JSONObject jsonobject= new JSONObject();
		 
	 System.out.println("当前登录管理员------------------------"+username);

		 if(this.username==null)   
			   jsonobject.put("userName","您当前未登录");
		   else
		   {
			   user.setUserName(username);
			   jsonobject.put("userName","您好:  "+user.getUserName()+"管理员");
			  
		   }
	
		 this.username=null;
		 
		 JSONArray jsonarray = new JSONArray();
		 jsonarray.add(jsonobject);
		 
		 jsonobject.element("people", jsonarray);
		 
		 return jsonobject;
	 }

		
	@RequestMapping(value="picture")
	public String picture(){
		return "picture-show";
	}
	
	@RequestMapping(value="invo")
	public String invoice_data(){return "datatables";}
	 
	/**
	 *  返回当前管理员总数
	 */
	@RequestMapping(value="sumadmin",produces="application/json")
	@ResponseBody
	public JSONObject sum_admin(){
		 System.out.println("返回当前管理员总数----------------------");
		 admin_role.select_sumadmin();
		 List<Integer> list = new ArrayList<Integer>();
		 JSONObject  jsonobject = new JSONObject();
	
		 Long sum_value = list.stream().count();
		
		 jsonobject.put("当前管理员总数为:",sum_value);
		
		 JSONArray jsonarray = new JSONArray();
		 
		 jsonarray.add(jsonobject);
		 
		 jsonobject.element("people", jsonarray);
		 
		 return jsonobject;
		 		
	}
	
	/**
	 * 
	 * @return  返回当前管理员信息
	 */

	@RequestMapping(value="pinformation_view")
	public String pinformation_view(){return "pinformation";}
	
	@RequestMapping(value="pinformation",produces="application/json")
	@ResponseBody
	public JSONObject pinformation(String admin_name){
		
		
		return null;
	}
	
}
