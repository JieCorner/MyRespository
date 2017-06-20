package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.bean.User;
import com.spring.dao.UserDAO;
import com.spring.dao.impl.UserDAOImpl;

public class UserService {
	private UserDAO userDAO;
	private String serviceName;
	public String getServiceName() {
		return serviceName;
	}

	public UserService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}


	public UserService(UserDAO userDAO, String serviceName) {
		super();
		this.userDAO = userDAO;
		this.serviceName = serviceName;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void add(User u){
		System.out.print("UserService:");
		this.userDAO.save(u);
	}
}
