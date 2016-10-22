package com.cn.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/** @param invoiceid  发票号
 * @param name 客户名称
 * @param banckaccount 开户银行
 *@param  address 地址
 *@param  accountnumber 账号
 *@param Salesman 业务员
 *@param depart 销售所属部门
 *@param invodate  开具发票日期
 *对应Oracle 表  Invoice 
 */
@Entity
public class Invoice_pojo {
	
	
	private Integer invoiceid;
	 private Date  invodate;
	private String  name;
     private String banckaccount;
     private  String address;
     private   Integer accountnumber;
     private   String depart;
     private String  salesman;
      
	
	 public Integer getInvoiceid() {
		return invoiceid;
	}
	public void setInvoiceid(Integer invoiceid) {
		this.invoiceid = invoiceid;
	}
	public Date getInvodate() {
		return invodate;
	}
	public void setInvodate(Date invoString) {
		/*
		  SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
		  try {
			this.invodate=(Date) simpleDateFormat.parse(invoString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		*/
		this.invodate=invoString;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBanckaccount() {
		return banckaccount;
	}
	public void setBanckaccount(String banckaccount) {
		this.banckaccount = banckaccount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(Integer accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getSalesman() {
		return salesman;
	}
	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountnumber == null) ? 0 : accountnumber.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((banckaccount == null) ? 0 : banckaccount.hashCode());
		result = prime * result + ((depart == null) ? 0 : depart.hashCode());
		result = prime * result + ((invodate == null) ? 0 : invodate.hashCode());
		result = prime * result + ((invoiceid == null) ? 0 : invoiceid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((salesman == null) ? 0 : salesman.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice_pojo other = (Invoice_pojo) obj;
		if (accountnumber == null) {
			if (other.accountnumber != null)
				return false;
		} else if (!accountnumber.equals(other.accountnumber))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (banckaccount == null) {
			if (other.banckaccount != null)
				return false;
		} else if (!banckaccount.equals(other.banckaccount))
			return false;
		if (depart == null) {
			if (other.depart != null)
				return false;
		} else if (!depart.equals(other.depart))
			return false;
		if (invodate == null) {
			if (other.invodate != null)
				return false;
		} else if (!invodate.equals(other.invodate))
			return false;
		if (invoiceid == null) {
			if (other.invoiceid != null)
				return false;
		} else if (!invoiceid.equals(other.invoiceid))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salesman == null) {
			if (other.salesman != null)
				return false;
		} else if (!salesman.equals(other.salesman))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Invoice_pojo [invoiceid=" + invoiceid + ", invodate=" + invodate + ", name=" + name + ", banckaccount="
				+ banckaccount + ", address=" + address + ", accountnumber=" + accountnumber + ", depart=" + depart
				+ ", salesman=" + salesman + "]";
	}


       
       
}
