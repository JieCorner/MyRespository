package com.springaop.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
//@Aspect
public class MyInterceptor {
//	private void loginMethod(){}
//	@Around("loginMethod() && args(name)")
	public Object doAround(ProceedingJoinPoint pjp,String name) throws Throwable{
		if("sise".equals(name)){
			Object result=pjp.proceed();
			System.out.println(name+",您已经成功登录，欢迎您！");
		}else{
			System.out.println("用户名不正确，您没有权限登录！");
		}
		return null;
	}
}
