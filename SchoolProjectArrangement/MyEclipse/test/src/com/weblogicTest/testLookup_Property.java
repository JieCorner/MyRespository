package com.weblogicTest;

import java.io.FileInputStream;
import java.util.Properties;

import javax.naming.*;

public class testLookup_Property {
	public static void main(String[] args)
	{
		System.out.println("Lookup Begin...");
		try {
			Properties props=new Properties();
			props.load(new FileInputStream(".\\src\\com\\weblogicTest\\jndiprovider.properties"));
			InitialContext ctx=new InitialContext(props);
			String result;
			result=(String)ctx.lookup("java");
			System.out.println("result is:"+result);
			System.out.println("lookup end!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
