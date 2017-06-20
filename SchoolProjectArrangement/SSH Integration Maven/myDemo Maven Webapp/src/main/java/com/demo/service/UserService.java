package com.demo.service;

import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.UserDAO;


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
