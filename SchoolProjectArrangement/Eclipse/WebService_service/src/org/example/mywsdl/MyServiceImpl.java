package org.example.mywsdl;

import javax.jws.WebService;

@WebService(endpointInterface="org.example.mywsdl.IMyService",
	targetNamespace = "http://www.example.org/mywsdl/",
		wsdlLocation="META-INF/wsdl/mywsdl.wsdl")
public class MyServiceImpl implements IMyService
{
	@Override
	public int add(int a, int b,String licenseInfo)
	{
		System.out.println(licenseInfo);
		System.out.println(a+b);
		
		return a+b;
	}

	
	
	@Override
	public int divide(int num1, int num2)
	{
		System.out.println(num1/num2);
			return num1/num2;
	}
	
}
