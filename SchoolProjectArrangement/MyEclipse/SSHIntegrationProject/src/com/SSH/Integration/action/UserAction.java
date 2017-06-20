package com.SSH.Integration.action;

import com.SSH.Integration.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("UserAction's execute method is invoked...");
		this.userService.add();
		return SUCCESS;
	}
	
}
