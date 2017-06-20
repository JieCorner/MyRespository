package org.example.mywsdl;

import javax.xml.ws.Endpoint;

public class MyService
{
	public static void main(String[] args)
	{
		System.out.println("·þÎñÆ÷Æô¶¯");
		Endpoint.publish("http://localhost:8989/ms", new MyServiceImpl());
	}
}
