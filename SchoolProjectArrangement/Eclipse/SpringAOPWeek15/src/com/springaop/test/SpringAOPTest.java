package com.springaop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAOPTest {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		LoginService loginService=(LoginService)ctx.getBean("loginService");
//		loginService.login("sise");
		loginService.login("AAA");
	}
}
