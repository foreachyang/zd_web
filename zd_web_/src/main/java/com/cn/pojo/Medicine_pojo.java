package com.cn.pojo;

import java.util.Date;

/**
 * @author  周杰
 *  @parem drug_name  销售的药品  
 *  @param Measurement 销售药品数量
 *  @param Remark 备注
 *  @param  Markeldate 销售时间
 *  @param Inventory  进货商
 *  @param Salesman   业务员
 */
public class Medicine_pojo {
     public String getDrug_name() {
		return drug_name;
	}
	public void setDrug_name(String drug_name) {
		this.drug_name = drug_name;
	}
	public String getMeasurement() {
		return Measurement;
	}
	public void setMeasurement(String measurement) {
		Measurement = measurement;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public Date getMarkeldate() {
		return Markeldate;
	}
	public void setMarkeldate(Date markeldate) {
		Markeldate = markeldate;
	}
	public String getInventory() {
		return Inventory;
	}
	public void setInventory(String inventory) {
		Inventory = inventory;
	}
	public String getSalesman() {
		return Salesman;
	}
	public void setSalesman(String salesman) {
		Salesman = salesman;
	}
	private String  drug_name;
     private String Measurement;
     private String Remark;
     private Date  Markeldate;
     private String Inventory;
     private String  Salesman;
     
}
