package com.cn.pojo;

public class User {
  private Long id;

private String userName;
  private String password;
  private Integer roleid;
  private String  salt;
  private Integer sync;



public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

  
public Integer getSync() {
	return sync;
}
public void setSync(Integer sync) {
	this.sync = sync;
}


public Integer getRoleid() {
	return roleid;
}
public void setRoleid(Integer roleid) {
	this.roleid = roleid;
}


public String getSalt() {
	return salt;
}
public void setSalt(String salt) {
	this.salt = salt;
}

public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


public String getCredentialsSalt() {  
    return userName + salt;  
}
@Override
public String toString() {
	return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", roleid=" + roleid + ", salt="
			+ salt + ", sync=" + sync + "]";
}

 
}
