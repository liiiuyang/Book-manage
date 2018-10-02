package com.tjetc.domain;

public class User {
	//属性
	private int userid;
	private String username;
	private String password;
	private String mail;
	private String phone;
	private String address;
	
	public User(){
		System.out.println("调用无参构造方法。。。。");
	}
	
	
	public User(int userid, String username, String password, String mail, String phone, String address) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.phone = phone;
		this.address = address;
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, String mail, String phone, String address) {
		super();
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.phone = phone;
		this.address = address;
	}

	//添加set和get方法
	public int getUserid() {
		return userid;
	}
	

	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
	
}
