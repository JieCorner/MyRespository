package com.spring1;

public class UserDAOImpl3 implements UserDAO
{
	private UserDAO userDAO=new UserDAOImpl();
	public void save(User u)
	{
		new LogInterceptor().beforeMethod();
		userDAO.save(u);
	}
}
