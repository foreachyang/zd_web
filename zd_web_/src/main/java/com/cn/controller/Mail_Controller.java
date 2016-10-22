package com.cn.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.pojo.Mail_pojo;
import com.cn.service.Mailer_Service;
import com.cn.service.Impl.ApplicationMailer_Impl;
import com.cn.service.Impl.Mail;

@Controller
public class Mail_Controller {

	@Autowired(required=false)
	ApplicationMailer_Impl  mailer;
	
	@Autowired(required=false)
	Mail mail;
	
	@RequestMapping(value="mail_test")
	public String test() throws MessagingException{
		/*
		Mail_pojo email = new Mail_pojo();
		email.setCc("2922646394@qq.com");	
		email.setSubject("测试医药系统邮件服务    测试人:周杰");
		email.setAddressee("2922646394@qq.com");
		email.setContent("test");
		System.out.println("测试 邮件 系统 流量入口");
		mailer.sendMailByAsynchronousMode(email);
		*/
		mail.sendMail();
		return "test";
		
	}
}
