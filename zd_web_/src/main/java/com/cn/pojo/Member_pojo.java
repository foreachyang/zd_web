package com.cn.pojo;

import javax.persistence.Entity;

/**
 * 
 * @author 周杰
 *
 *把药品销售给哪个公司的药品采购员， 他所对应的公司的销售人员是谁？
 *@table  T_MEMBER
 */
@Entity
public class Member_pojo {
	private Long id;
    private String customername;  //哪个公司的采购员或负责人
    private String gender;  // 他的性别
    private Integer cellphonenumber; //他的手机号
    private String  staff; // 哪个员工负责与被销售方进行药品销售
    private String sync; // 我方员工是否已经离职或者违规操作导致账号停用
    private String company; //客户所在公司
    private String mailbox; //他的邮箱
    
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getCellphonenumber() {
		return cellphonenumber;
	}
	public void setCellphonenumber(Integer cellphonenumber) {
		this.cellphonenumber = cellphonenumber;
	}
	public String getStaff() {
		return staff;
	}
	public void setStaff(String staff) {
		this.staff = staff;
	}
	public String getSync() {
		return sync;
	}
	public void setSync(String sync) {
		this.sync = sync;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getMailbox() {
		return mailbox;
	}
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
	
	
	@Override
	public String toString() {
		return "Member_pojo [id=" + id + ", customername=" + customername + ", gender=" + gender + ", cellphonenumber="
				+ cellphonenumber + ", staff=" + staff + ", sync=" + sync + ", company=" + company + ", mailbox="
				+ mailbox + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cellphonenumber == null) ? 0 : cellphonenumber.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((customername == null) ? 0 : customername.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((mailbox == null) ? 0 : mailbox.hashCode());
		result = prime * result + ((staff == null) ? 0 : staff.hashCode());
		result = prime * result + ((sync == null) ? 0 : sync.hashCode());
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
		Member_pojo other = (Member_pojo) obj;
		if (cellphonenumber == null) {
			if (other.cellphonenumber != null)
				return false;
		} else if (!cellphonenumber.equals(other.cellphonenumber))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (customername == null) {
			if (other.customername != null)
				return false;
		} else if (!customername.equals(other.customername))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (mailbox == null) {
			if (other.mailbox != null)
				return false;
		} else if (!mailbox.equals(other.mailbox))
			return false;
		if (staff == null) {
			if (other.staff != null)
				return false;
		} else if (!staff.equals(other.staff))
			return false;
		if (sync == null) {
			if (other.sync != null)
				return false;
		} else if (!sync.equals(other.sync))
			return false;
		return true;
	}
    
    
    
}
