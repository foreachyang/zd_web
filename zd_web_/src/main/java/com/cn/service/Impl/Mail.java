package com.cn.service.Impl;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.sun.mail.util.MailSSLSocketFactory;

@Service
@Configuration
public class Mail {
	

	public void sendMail() {
		System.out.println("jie shu mail ------------------------------------------");
		//String host = "smtp.exmail.qq.com";
		String host = "smtp.qq.com";
		int port = 465;
		String username = "2922646394@qq.com";
		String password = "zzonpsaestloddje";// qq邮箱填写随机生成的校验码，其它邮箱可以直接输登陆密码

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
			// 建立一个要发送的信息(邮件的标题，内容等)
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("2922646394@qq.com"));// 发件人邮箱号
			// 邮件标题
			msg.setSubject("答案为：");

			// 构造Multipart
			Multipart mp = new MimeMultipart();
			// 向Multipart添加正文
			MimeBodyPart mbpContent = new MimeBodyPart();
			mbpContent.setText("queue 是FIFO性质的。 通常在日常开发中用于同步或优先性质的消息传递，  Stack是先进后出， 典型表现为递归， 每一个function 都会被压入栈中，"
					+ "无论是Queue 还是Stack 他们都是对List进行载体");

			// 将BodyPart添加到MultiPart中
			mp.addBodyPart(mbpContent);
			// 记录所有附件文件的集合
			List<String> attachments = new ArrayList<String>();
			attachments.add("D:\\test");
			
			for (String efile : attachments) {
				MimeBodyPart mbpFile = new MimeBodyPart();
				// 以文件名创建FileDataSource对象
				FileDataSource fds = new FileDataSource(efile);
				// 处理附件
				mbpFile.setDataHandler(new DataHandler(fds));
				mbpFile.setFileName(fds.getName());
				// 将BodyPart添加到MultiPart中
				mp.addBodyPart(mbpFile);
			}
            //清空附件列表 释放内存？？
            attachments.clear();
			msg.setContent(mp);

			// 发送信息的工具
			Transport transport = session.getTransport();
			// 发件人邮箱号// 和密码
			transport.connect(host, port, username, password);
			transport.sendMessage(msg, new Address[] { new InternetAddress("1219508694@qq.com"),new InternetAddress("1219508694@qq.com") });// 对方的地址
			transport.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("jie shu mail ------------------------------------------");
	}
	
}
