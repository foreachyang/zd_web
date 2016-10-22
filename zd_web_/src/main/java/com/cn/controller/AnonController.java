package com.cn.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;
import com.octo.captcha.service.multitype.GenericManageableCaptchaService;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@Controller()
public class AnonController {

  @Autowired
  private GenericManageableCaptchaService captchaService;

 
  boolean flag=false;
  
  String Captcha;
  
 public String getCaptcha() {
	return Captcha;
}

public void setCaptcha(String captcha) {
	Captcha = captcha;
	
}


@RequestMapping(value = "/getcode")
  public void getCode( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

	  byte[] captchaChallengeAsJpeg = null;
	    // 输出jpg的字节流
	  String captchaId;
	    ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
	    try {
	                
	        captchaId=httpServletRequest.getSession().getId();
	      BufferedImage challenge = (BufferedImage) captchaService
	          .getChallengeForID(captchaId,
	              httpServletRequest.getLocale());

	 
	      JPEGImageEncoder jpegEncoder = JPEGCodec
	          .createJPEGEncoder(jpegOutputStream);
	      jpegEncoder.encode(challenge);
	      captchaChallengeAsJpeg = jpegOutputStream.toByteArray();

	      //图片不缓存
	      httpServletResponse.setHeader("Cache-Control", "no-store");
	      httpServletResponse.setHeader("Pragma", "no-cache");
	      httpServletResponse.setDateHeader("Expires", 0);
	      httpServletResponse.setContentType("image/jpeg");
	      
	      ServletOutputStream responseOutputStream = httpServletResponse
	          .getOutputStream();
	
	      responseOutputStream.write(captchaChallengeAsJpeg);
	   
	  	
	      responseOutputStream.flush();
	    responseOutputStream.close();

	    } catch (Exception e) {
	    	
	      try {
	        httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);

	      } catch (IOException e1) {
	        e1.printStackTrace();
	      }
	     
	    	System.out.println("第一个try 块的异常");
	    	e.printStackTrace();
  
   }
	    

 }
@RequestMapping(value = "validateImage") 
public void ValidateCaptchaImage( AnonController str, HttpServletRequest request,   HttpServletResponse response)throws ServletException , IOException { 
    Boolean isResponseCorrect = Boolean.FALSE;      

    String captchaId = request.getSession().getId();      
       
   
    try {      
        if(isResponseCorrect = captchaService.validateResponseForID(captchaId, str.getCaptcha())) System.out.println("true");
        else System.out.println("false");
    } catch (CaptchaServiceException e) {      

    }      
   
    
      
}      
}

 
 
	  

  
  
  