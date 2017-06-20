package com.struts2.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author:ZhengGengJie
 * @description:
 * @package:com.struts2.action
 * @time:2017-3-10 下午05:23:24
 */
public class LoginAction extends ActionSupport{
	private String username;
	private String password;
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
	
	public String execute(){
		if("jie".equals(username)&&"0818".equals(password)){
			HttpServletRequest req=ServletActionContext.getRequest();
			req.getSession().setAttribute("username", "jie1440112234");
			System.out.println("asd");
			return SUCCESS;
		}else{
			addActionError("用户名或密码错误!");
			return LOGIN;
		}
	}
	@Override
	public void validate() {
		if(username==null||"".equals(username.trim())){
			addFieldError("username","用户名不能为空!");
		}
		if(password==null||"".equals(password.trim())){
			addFieldError("password","密码不能为空!");
		}
	}
}
