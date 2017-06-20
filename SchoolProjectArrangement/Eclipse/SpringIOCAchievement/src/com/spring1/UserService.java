package com.spring1;

public class UserService
{
	private UserDAO userDAO=null;
	
	public UserDAO getUserDAO()
	{
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO)
	{
		this.userDAO = userDAO;
	}

	public void add(User u){
		this.userDAO.save(u);
	}
}
