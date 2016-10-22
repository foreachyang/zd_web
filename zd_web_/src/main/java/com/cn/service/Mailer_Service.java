package com.cn.service;

import javax.mail.MessagingException;

import com.cn.pojo.Mail_pojo;

public interface Mailer_Service  {
	  public void sendMailByAsynchronousMode (final Mail_pojo email)throws MessagingException;
}
