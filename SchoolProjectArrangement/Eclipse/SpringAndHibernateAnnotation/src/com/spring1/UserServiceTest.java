package com.spring1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserServiceTest
{
	@Test
	public void testAdd() throws Exception
	{	
		ClassPathXmlApplicationContext factory=new ClassPathXmlApplicationContext("beans.xml");
		UserService service=(UserService)factory.getBean("userService");
		service.add(new User(2,"haha"));
		
		factory.destroy();
	}
}
