package com.cn.service.Impl;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.cn.pojo.Mail_pojo;
import com.cn.service.Mailer_Service;
import com.sun.mail.util.MailSSLSocketFactory;

@Service
@Configuration
public class ApplicationMailer_Impl  implements Mailer_Service{

	 @Autowired
	 private JavaMailSender mailSender;
	 
	 @Autowired
	 private TaskExecutor taskExecutor;
	 
	 @Autowired
	 private SimpleMailMessage preConfig;
	
	 /**
	  *  同步发送邮件
	 * @throws MessagingException 
	  */
	public void sendMailByAsynchronousMode(Mail_pojo email) throws MessagingException {
		
		Properties props = System.getProperties();

		try {
			// 普通客户端
			props.setProperty("mail.smtp.auth", "true");
			// 选择协议
			props.setProperty("mail.transport.protocol", "smtp");
			MailSSLSocketFactory sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.ssl.socketFactory", sf);
			//
			Session session = Session.getDefaultInstance(props);
			// 设置debug模式 在控制台看到交互信息
			session.setDebug(true);

		MimeMessage mime= new MimeMessage(session);
		
		MimeMessageHelper helper= new MimeMessageHelper(mime,true,"utf-8");
		helper.setFrom("2922646394@qq.com");
		helper.setTo(InternetAddress.parse(email.getAddressee()));
		helper.setSubject(email.getSubject());//邮件主题    
	    helper.setText(email.getContent(), true);//true表示设定html格式  
	         mailSender.send(mime);
	}catch(Exception e){}
	}


}
