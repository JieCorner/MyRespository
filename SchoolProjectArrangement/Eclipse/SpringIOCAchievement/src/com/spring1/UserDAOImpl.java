package com.spring1;

public class UserDAOImpl implements UserDAO
{
	@Override
	public void save(User u)
	{
		System.out.println("a user saved!");
	}
}
