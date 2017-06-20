package com.javabean;

public class UserInfo {
	private String UserName;
	private String Sex;
	private String Email;
	private String Phone;
	private String PassWord;
	public UserInfo(){
		
	}
	public UserInfo(String UserName,String Sex,String Email,String Phone) {
		this.Email=Email;
		this.UserName=UserName;
		this.Phone=Phone;
		this.Sex=Sex;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
}
