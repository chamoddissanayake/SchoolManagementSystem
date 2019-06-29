package com.itp.model;

public class Student {
	private String sId;
	private String password;
	private String secured_password;
	private String salt;
	private String email;
	
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecured_password() {
		return secured_password;
	}
	public void setSecured_password(String secured_password) {
		this.secured_password = secured_password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
