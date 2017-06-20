package com.spring1;

public class UserDAOImpl2 extends UserDAOImpl
{
	public void save(User u)
	{
		System.out.println("save start...");
		super.save(u);
	}
}
