package com.cn.pojo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author 周杰
 * 
 *   产品实体类 对应Oracle 表空间 SYSTEM  表t_product
 *   
 *   @param  drug_name  药品名称
 *   @param  drug_type  药品分类
 *   @param  drug_norms  药品规格
 *   @param  drug_field 药品材料
 *   @param const_price   最低销售价
 *   @param market_price   市场价格
 *   @param drug_intro  简介
 */
public class Product_pojo {

	private String datr;
 
    private Long id;

	
	@NotEmpty(message="drugs")
	private String drug_name;  //药品名称
	 
	  @NotEmpty(message="drug_type")
	   private String drug_type;  //药品分类
	  
	   @NotNull(message="duugs")
	   private  String commrnt; // 是否允许评论
	  
	   @NotEmpty(message="drugs")  
	   private  String  drug_field;  //药品材料
	   
	   private String  supplier;  //最低销售价格
	   private  String company;  // 价格计算单位
	   
	   @NotEmpty(message="drugs") 
	   private  String weight;  //药品重量
	   
	   @NotEmpty(message="drugs") 
	   private String  wholesale; //批发价格
	   @NotEmpty(message="drugs")  
	   private String  const_price;  //成本销售价格
	   private String  market_price; //市场价格
	   private  String  drug_intro;  //药品摘要
	public String getDatr() {
		return datr;
	}
	public void setDatr(String datr) {
		this.datr = datr;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDrug_name() {
		return drug_name;
	}
	public void setDrug_name(String drug_name) {
		this.drug_name = drug_name;
	}
	public String getDrug_type() {
		return drug_type;
	}
	public void setDrug_type(String drug_type) {
		this.drug_type = drug_type;
	}
	public String getCommrnt() {
		return commrnt;
	}
	public void setCommrnt(String commrnt) {
		this.commrnt = commrnt;
	}
	public String getDrug_field() {
		return drug_field;
	}
	public void setDrug_field(String drug_field) {
		this.drug_field = drug_field;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getWholesale() {
		return wholesale;
	}
	public void setWholesale(String wholesale) {
		this.wholesale = wholesale;
	}
	public String getConst_price() {
		return const_price;
	}
	public void setConst_price(String const_price) {
		this.const_price = const_price;
	}
	public String getMarket_price() {
		return market_price;
	}
	public void setMarket_price(String market_price) {
		this.market_price = market_price;
	}
	public String getDrug_intro() {
		return drug_intro;
	}
	public void setDrug_intro(String drug_intro) {
		this.drug_intro = drug_intro;
	}
	@Override
	public String toString() {
		return "Product_pojo [datr=" + datr + ", id=" + id + ", drug_name=" + drug_name + ", drug_type=" + drug_type
				+ ", commrnt=" + commrnt + ", drug_field=" + drug_field + ", supplier=" + supplier + ", company="
				+ company + ", weight=" + weight + ", wholesale=" + wholesale + ", const_price=" + const_price
				+ ", market_price=" + market_price + ", drug_intro=" + drug_intro + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commrnt == null) ? 0 : commrnt.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((const_price == null) ? 0 : const_price.hashCode());
		result = prime * result + ((datr == null) ? 0 : datr.hashCode());
		result = prime * result + ((drug_field == null) ? 0 : drug_field.hashCode());
		result = prime * result + ((drug_intro == null) ? 0 : drug_intro.hashCode());
		result = prime * result + ((drug_name == null) ? 0 : drug_name.hashCode());
		result = prime * result + ((drug_type == null) ? 0 : drug_type.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((market_price == null) ? 0 : market_price.hashCode());
		result = prime * result + ((supplier == null) ? 0 : supplier.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		result = prime * result + ((wholesale == null) ? 0 : wholesale.hashCode());
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
		Product_pojo other = (Product_pojo) obj;
		if (commrnt == null) {
			if (other.commrnt != null)
				return false;
		} else if (!commrnt.equals(other.commrnt))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (const_price == null) {
			if (other.const_price != null)
				return false;
		} else if (!const_price.equals(other.const_price))
			return false;
		if (datr == null) {
			if (other.datr != null)
				return false;
		} else if (!datr.equals(other.datr))
			return false;
		if (drug_field == null) {
			if (other.drug_field != null)
				return false;
		} else if (!drug_field.equals(other.drug_field))
			return false;
		if (drug_intro == null) {
			if (other.drug_intro != null)
				return false;
		} else if (!drug_intro.equals(other.drug_intro))
			return false;
		if (drug_name == null) {
			if (other.drug_name != null)
				return false;
		} else if (!drug_name.equals(other.drug_name))
			return false;
		if (drug_type == null) {
			if (other.drug_type != null)
				return false;
		} else if (!drug_type.equals(other.drug_type))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (market_price == null) {
			if (other.market_price != null)
				return false;
		} else if (!market_price.equals(other.market_price))
			return false;
		if (supplier == null) {
			if (other.supplier != null)
				return false;
		} else if (!supplier.equals(other.supplier))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		if (wholesale == null) {
			if (other.wholesale != null)
				return false;
		} else if (!wholesale.equals(other.wholesale))
			return false;
		return true;
	}

	   
	   
	
 
	
}
