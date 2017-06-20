package com.spring1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LogInterceptor
{
	@Before("execution(public void com.spring1.UserDAOImpl.save(com.spring1.User))")
	public void before(){
		System.out.println("method start!");
	}
	
	@Pointcut("execution(public * com.spring1.UserDAOImpl.*(..))")
	public void myMethod(){
		System.out.println("method start!");
	}
	
	@AfterReturning("execution(public * com.spring1.UserDAOImpl.*(..))")
	public void doneAfter(){
		System.out.println("done finish!");
	}
	
	@AfterThrowing("execution(public * com.spring1.UserDAOImpl.*(..))")
	public void ThrowingException(){
		System.out.println("throwing Exception!");
	}
	
	//让DAOImpl的save方法抛出异常
	@Around("myMethod()")
	public void StopThrowing(){
		System.out.println("STOP Throwing Exception!");
	}
}
