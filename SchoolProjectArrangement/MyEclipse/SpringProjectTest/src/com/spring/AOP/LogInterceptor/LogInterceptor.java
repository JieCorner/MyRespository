package com.spring.AOP.LogInterceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component("LogInterceptor")
public class LogInterceptor{
	
	@Before("execution(public void com.spring.dao.impl.UserDAOImpl.save(com.spring.bean.User))")
	public void beforeMethod(){
		System.out.println("Log:save statr!");
	}
	
	@AfterReturning("execution(public void com.spring.dao.impl.UserDAOImpl.save(com.spring.bean.User))")
	public void afterMethod(){
		System.out.println("Log:after save!");
	}
	
	@Around("execution(public void com.spring.dao.impl.UserDAOImpl.save(com.spring.bean.User))")
	public void AroundMethod(ProceedingJoinPoint pjpt) throws Throwable{
		System.out.println("around strat!");
		pjpt.proceed();
		System.out.println("around end!");
	}
	
	@Before("execution(public void com.spring.service.UserService.add(com.spring.bean.User))")
	public void beforeMethodforService(){
		System.out.println("Log:Service save statr!");
	}
	
}
