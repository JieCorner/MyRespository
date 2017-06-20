package com.spring1;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.spring2.BeanFactory;
import com.spring2.ClassPathXmlApplicationContext;

public class UserServiceTest
{

	@Test
	public void testAdd() throws Exception
	{
		BeanFactory applicationContext=new ClassPathXmlApplicationContext();
		
		UserService service=(UserService)applicationContext.getBean("userService");
		
		User u=new User();
		u.setUsername("zhangsan");
		u.setPassword("zhangsan");
//		service.add(u);
		
	}

	@Test
	public void testProxy(){
		UserDAO userDAO=new UserDAOImpl();
		LogInterceptor li=new LogInterceptor();
		li.setTarget(userDAO);
		//生成一个代理实例
		UserDAO userDAOProxy=(UserDAO)Proxy.newProxyInstance(userDAO.getClass().getClassLoader(),new Class[]{UserDAO.class} , li);
		userDAOProxy.save(new User());
	}
}
