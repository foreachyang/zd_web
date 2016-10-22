package com.cn.pojo;

import javax.persistence.Entity;
/**
 * 
 * @author
 *
 *@table()
 */
@Entity
public class Member_product_pojo {

	private  Long id;
	private String member_name;  // 哪个用户
	 private String member_product;  // 购买了哪个产品
	 private String member_s; //购买的数量
	 
	 
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_product() {
		return member_product;
	}
	public void setMember_product(String member_product) {
		this.member_product = member_product;
	}
	public String getMember_s() {
		return member_s;
	}
	public void setMember_s(String member_s) {
		this.member_s = member_s;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((member_name == null) ? 0 : member_name.hashCode());
		result = prime * result + ((member_product == null) ? 0 : member_product.hashCode());
		result = prime * result + ((member_s == null) ? 0 : member_s.hashCode());
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
		Member_product_pojo other = (Member_product_pojo) obj;
		if (member_name == null) {
			if (other.member_name != null)
				return false;
		} else if (!member_name.equals(other.member_name))
			return false;
		if (member_product == null) {
			if (other.member_product != null)
				return false;
		} else if (!member_product.equals(other.member_product))
			return false;
		if (member_s == null) {
			if (other.member_s != null)
				return false;
		} else if (!member_s.equals(other.member_s))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Member_product_pojo [member_name=" + member_name + ", member_product=" + member_product + ", member_s="
				+ member_s + "]";
	}
	 
	
	
	
	
	 
}
