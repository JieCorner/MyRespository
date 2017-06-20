package com.JunitTest.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.bean.User;
import com.spring.service.OtherService;

public class OtherServiceTest {

	@Test
	public void testAdd() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		OtherService service=(OtherService)ctx.getBean("OtherService");
		User u=new User();
		service.add(u);
		System.out.println(service.getServiceName());
	}
}
