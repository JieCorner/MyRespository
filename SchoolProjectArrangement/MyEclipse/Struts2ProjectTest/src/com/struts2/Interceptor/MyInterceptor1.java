package com.struts2.Interceptor;

import org.xml.sax.SAXException;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Intercepter;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.UnmarshallingContext.State;

public class MyInterceptor1 implements Interceptor, Intercepter {

	private String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object intercept(State arg0, Object arg1) throws SAXException {
		// TODO Auto-generated method stub
		return null;
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		System.out.println(name);
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("before");
		String result=arg0.invoke();
		System.out.println("after");
		return result;
	}

}
