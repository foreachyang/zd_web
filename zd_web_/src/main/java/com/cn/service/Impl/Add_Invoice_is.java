package com.cn.service.Impl;

import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.cn.pojo.Invoice_pojo;

/*
 *效验发票 
 */
@Transactional
@Service
@Configuration
public class Add_Invoice_is {


	  Invoice_pojo invoice_pojo;
	   
	
	   void notnull() {  
	    	 Objects.requireNonNull(invoice_pojo, "没有检测到值，对象为空");
	    }
	   
	   
}
