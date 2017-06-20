package com.news.management.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.news.management.bean.User;
import com.news.management.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateUserAction extends ActionSupport {
	private UserService userService;
	private User user;
	public Map responseJson;
	
	public Map getResponseJson() {
		return responseJson;
	}
	public void setResponseJson(Map responseJson) {
		this.responseJson = responseJson;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(@Qualifier("userService")UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println(user.getId());
		User Getuser=userService.getUserByID(user.getId());
		user=Getuser;
		return SUCCESS;
	}
	
	public String updateUser() throws Exception {
		User getUser=userService.getUserByID(Integer.parseInt(ServletActionContext. getRequest().getParameter("userId")));
		if(ServletActionContext. getRequest().getParameter("password")!=null&&ServletActionContext. getRequest().getParameter("password")!=""){
			getUser.setPassword(ServletActionContext. getRequest().getParameter("password"));
		}
		getUser.setEmail(ServletActionContext. getRequest().getParameter("email"));
		userService.UpdateUser(getUser);
		return SUCCESS;
	}
	
	public String SurePassword() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		User getUser=userService.getUserByID(Integer.parseInt(ServletActionContext. getRequest().getParameter("userId")));
		if(getUser.getPassword().equals(ServletActionContext. getRequest().getParameter("password"))){
			map.put("requestResult", "success");
		}else{
			map.put("requestResult", "fail");
		}
		this.setResponseJson(map);  
		return SUCCESS;
	}
	
}
