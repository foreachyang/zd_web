package com.cn.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.dao.Invoicedao;
import com.cn.pojo.Invoice_pojo;
import com.cn.service.InvoiceService;

@Transactional(readOnly=true, timeout=10000)
@Service
public class InvoiceImpl implements InvoiceService{

 @Autowired
 @Qualifier("invoicedao")
 Invoicedao invoicedao;

public int insertService(Invoice_pojo invoice_pojo) {
	System.out.println("xxxxdadadadaad");
	return invoicedao.insert_Invoice(invoice_pojo);
}


public List<Invoice_pojo> select_Invoice() {
	System.out.println("selectInvoice");
	
	List<Invoice_pojo> list = new ArrayList<Invoice_pojo>();
	list= invoicedao.select_Invoice();
	for (Invoice_pojo invoice_pojo2 : list) {
		 System.out.println(invoice_pojo2.getAddress()+"----"+invoice_pojo2.getName());
	}
	
	return list;
}
 
}
