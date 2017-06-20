package com.news.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.news.management.DAO.UserDAO;
import com.news.management.bean.User;

@Transactional
@Component
public class UserService {
	private UserDAO userDAO;
	
	@Autowired
	public void setUserDAO(@Qualifier("UserDAOImpl") UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	//用于增加用户
	public void add(User user) {
		this.userDAO.add(user);
	}
	//用于检查是否有相同用户名
	public boolean getUserByName(String username){
		return this.userDAO.getUserByName(username);
	}
	
	//用于检查用户名和密码对应的用户是否存在
	public User LoginOfUserExist(String username,String password){
		return this.userDAO.LoginOfUserExist(username, password);
	}
		
	public User getUserByID(int uid){
		return this.userDAO.getUserByID(uid);
	}
	
	public void UpdateUser(User user){
		this.userDAO.UpdateUser(user);
	}
}
