package com.JunitTest.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.bean.User;
import com.spring.dao.UserDAO;
import com.spring.service.UserService;

public class UserServiceTest {

	@Test
	public void testAdd() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		UserService service=(UserService)ctx.getBean("UserService");
		User u=new User();
		service.add(u);
		System.out.println(service.getServiceName());
	}
	
}
