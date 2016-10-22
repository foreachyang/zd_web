package com.cn.exception;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author周杰
 * <p> 管理异常界面， 返回异常信息 json
 */
@ControllerAdvice
public class DefaultExceptionHandler{
    /**
     * 没有权限 异常
     * <p/>
     * 
     */
	@RequestMapping(value="exception",produces="application/json")
    @ExceptionHandler({UnauthorizedException.class})
	@ResponseBody()
    public Map<String,Object> unauthoruzedException(){
		
	 System.out.println("UnauthorizedException--------------------------");	
		 Map<String,Object> map= new HashMap<String,Object>();
	  return map;
	}
	
	@RequestMapping(value="exceptiont",produces="application/json")
    @ExceptionHandler({IncorrectCredentialsException.class})
	@ResponseBody()
    public Map<String,Object> InterException(){
		
	 System.out.println("IncorrectCredentialsException--------------------------");	
		 Map<String,Object> map= new HashMap<String,Object>();
	  return map;
	}


}

