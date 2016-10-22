package com.cn.service;

import java.util.List;

import com.cn.pojo.Invoice_pojo;

public interface InvoiceService {
 public int insertService(Invoice_pojo invoice_pojo);
 public List<Invoice_pojo> select_Invoice();
}
