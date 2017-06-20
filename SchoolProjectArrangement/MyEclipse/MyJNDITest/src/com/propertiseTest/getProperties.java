package com.propertiseTest;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class getProperties {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//配置文件的路径要从src开始，因为编译出来的class与它不在同一个文件下
		 Properties pps = new Properties();
		InputStream in = new BufferedInputStream(new FileInputStream(".\\src\\com\\propertiseTest\\Test.properties"));
		pps.load(in);
		Enumeration en = pps.propertyNames(); //得到配置文件的名字
		while(en.hasMoreElements()) {
		String strKey = (String) en.nextElement();
		String strValue = pps.getProperty(strKey);
		System.out.println(strKey + "=" + strValue);
		 }
	}
}
