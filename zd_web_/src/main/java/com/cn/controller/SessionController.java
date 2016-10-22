package com.cn.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cn.type.Constants;

/*@RequiresPermissions("session:*")*/
@Controller
@RequestMapping("/sessions")
public class SessionController {

	@Autowired
	private SessionDAO sessionDAO;
	
	@RequestMapping()
	public String welcome(){
		 return "welcome";
	}
	
	@RequestMapping(value="list")
	@ResponseBody
	public Map<String,Integer> list() {
		Collection<Session> sessions=sessionDAO.getActiveSessions();

		 System.out.println(" session dao 方法  统计在线会话-----"+sessions.size());
		   Integer length=sessions.size();

		  Map<String,Integer> map= new HashMap<String,Integer>();
		   map.put("data",length);
		return  map;
	}
	
	@RequestMapping("/{sessionId}/forceLogout")
	public String forceLogout(@PathVariable("sessionId") String sessionId, RedirectAttributes redirectAttributes){
    
	try {
		Session session=sessionDAO.readSession(sessionId);
		
		if(session!=null) {
			session.setAttribute(Constants.SESSION_FORCE_LOGOUT_KEY,Boolean.TRUE);
		}
		
	}catch(Exception e) {}
	redirectAttributes.addFlashAttribute("msg","强制退出成功");
	
	return "redirect:/sessions";
	
	}
	
	
	
}

