package com.itp.model;

public class Parent {
	private String pid;
	private String password;
	private String secured_password;
	private String salt;
	private String Email;
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
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
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
	
}
