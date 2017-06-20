package com.weblogicTest;

import java.io.FileInputStream;
import java.util.Properties;

import javax.naming.*;

public class testBind_Properties {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Properties props=new Properties();
			props.load(new FileInputStream(".\\src\\com\\weblogicTest\\jndiprovider.properties"));
			InitialContext ctx=new InitialContext(props);
			String str="Hello world!";
			ctx.bind("java",str);
			System.out.println("object bound!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
