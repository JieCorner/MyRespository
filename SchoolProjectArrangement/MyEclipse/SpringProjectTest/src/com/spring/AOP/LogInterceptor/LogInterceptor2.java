package com.spring.AOP.LogInterceptor;

import org.springframework.stereotype.Component;

@Component("LogInterceptor2")
public class LogInterceptor2 {
	
	public void beforeMethod2(){
		System.out.println("Log2:save start2!");
	}
}
