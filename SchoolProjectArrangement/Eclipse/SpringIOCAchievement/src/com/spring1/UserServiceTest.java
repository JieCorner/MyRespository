package com.spring1;

import org.junit.Test;

import com.spring1.User;
import com.spring1.UserDAO;
import com.spring1.UserService;
import com.spring2.BeanFactory;
import com.spring2.ClassPathXmlApplicationContext;

public class UserServiceTest
{

	@Test
	public void testAdd() throws Exception
	{
		BeanFactory factory=new ClassPathXmlApplicationContext();
		
//		UserService service=new UserService();
//		UserDAO userDAO=(UserDAO)factory.getBean("u");
//		service.setUserDAO(userDAO);
//		User u=new User();
//		service.add(u);
		
		UserService service=(UserService)factory.getBean("userService");
		User u=new User();
		service.add(u);
	}

}
