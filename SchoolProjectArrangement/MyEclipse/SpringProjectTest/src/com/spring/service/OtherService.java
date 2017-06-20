package com.spring.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.spring.bean.User;
import com.spring.dao.UserDAO;

public class OtherService {
	private UserDAO userDAO;
	private String serviceName;
	public UserDAO getUserDAO() {
		return userDAO;
	}
//	@Autowired
//	public void setUserDAO(@Qualifier("UserDaoImpl") UserDAO userDAO) {
//		this.userDAO = userDAO;
//	}
	
	@Resource(name="UserDaoImpl")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public OtherService(UserDAO userDAO, String serviceName) {
		super();
		this.userDAO = userDAO;
		this.serviceName = serviceName;
	}
	public OtherService() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void add(User u){
		System.out.print("OtherService:");
		this.userDAO.save(u);
	}
}
