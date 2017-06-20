package com.SSH.Integration.service;

import org.springframework.transaction.annotation.Transactional;

import com.SSH.Integration.DAO.UserDAO;

@Transactional
public class UserService {
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void add() {
		this.userDAO.add();
		System.out.println("UserService's add method is invoked...");
	}
	
}
