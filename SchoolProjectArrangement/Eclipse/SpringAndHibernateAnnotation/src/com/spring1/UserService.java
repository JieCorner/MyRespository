package com.spring1;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component("userService")
public class UserService
{
	private UserDAO userDAO;
	
	public UserService()
	{
		super();
	}

	public UserDAO getUserDAO()
	{
		return userDAO;
	}
	@Resource(name="u")
	public void setUserDAO(UserDAO userDAO)
	{
		this.userDAO = userDAO;
	}

	public void add(User u){
		this.userDAO.save(u);
	}
	

}
