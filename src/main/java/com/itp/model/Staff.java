package com.itp.model;

public class Staff {
	protected String stfID;
	protected String password;
	protected String secured_password;
	protected String salt;
	protected String Email;
	
	public String getStfID() {
		return stfID;
	}
	public void setStfID(String stfID) {
		this.stfID = stfID;
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
