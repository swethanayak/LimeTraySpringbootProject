package com.example.demo.model;

public class UsersRegisterSignup {
	
	private  String name;
	private String userid;
	private String password;
	private String emailid;
	private long phonenumber;
	
	
	@Override
	public String toString() {
		return "Signup [name=" + name + ", userid=" + userid + ", password=" + password + ", emailid=" + emailid
				+ ", phonenumber=" + phonenumber + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	

}
