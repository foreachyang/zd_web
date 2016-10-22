/*
package com.cn.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class HandlerExceptionResolver_Impl  implements HandlerExceptionResolver{

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception es) {
		
		 if(es instanceof IncorrectCredentialsException)
			  System.out.println("IncorrectCredentials");
		
		return  new ModelAndView();
	}

}
*/