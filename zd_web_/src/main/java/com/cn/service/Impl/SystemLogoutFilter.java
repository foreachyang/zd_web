package com.cn.service.Impl;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 周杰
 *
 * 退出 并且清空缓存
 */
@Service
@Configuration
public class SystemLogoutFilter extends LogoutFilter {

	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception{
	
		Subject subject =getSubject(request,response);
		 String redirectUrl = getRedirectUrl(request, response, subject);
		 
		 try {

	            subject.logout();

	        } catch (SessionException ise) {

	           ise.printStackTrace();

	        }

	        issueRedirect(request, response, redirectUrl);

   //不执行任何过滤器
	        return false;
	}
}
