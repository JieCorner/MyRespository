package com.spring1;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring1.aop.Log;
import com.spring1.aop.User;
import com.spring1.dao.LogDAO;
import com.spring1.dao.UserDAO;
@Component("userService")
public class UserService
{
	private UserDAO userDAO;
	private LogDAO logDAO;
	
	public LogDAO getLogDAO()
	{
		return logDAO;
	}
	@Resource(name="log")
	public void setLogDAO(LogDAO logDAO)
	{
		this.logDAO = logDAO;
	}

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
	@Transactional(propagation=Propagation.REQUIRED)
	public void add(User u){
		this.userDAO.save(u);
		Log log=new Log();
		log.setMsg("a user saved");
		logDAO.savelog(log);
	}
	

}
