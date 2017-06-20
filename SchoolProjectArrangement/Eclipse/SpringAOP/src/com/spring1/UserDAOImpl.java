package com.spring1;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;
@Component("u")
public class UserDAOImpl implements UserDAO
{
	@Override
	public void save(User u)
	{
		System.out.println("user saved!");
		throw new RuntimeException("exception");
	}
}
