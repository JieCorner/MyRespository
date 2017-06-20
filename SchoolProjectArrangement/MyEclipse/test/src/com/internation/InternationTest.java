package com.internation;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class InternationTest {
	public static void main(String[] args) {
//		Locale[] locales =Locale.getAvailableLocales();
//		for(Locale locale:locales){
//			System.out.println(locale.getDisplayCountry()+":"+locale.getCountry());
//		}
		
		
//		Locale[] locales =Locale.getAvailableLocales();
//		for(Locale locale:locales){
//			System.out.println(locale.getDisplayLanguage()+":"+locale.getLanguage());
//		}
		
//		System.out.println(Locale.getDefault());
//		ResourceBundle bundle=ResourceBundle.getBundle("shengsiyuan");     //配置文件放在src目录下
//		String value=bundle.getString("hello");
//		System.out.println(value);
		
//		System.out.println(Locale.getDefault());
//		ResourceBundle bundle=ResourceBundle.getBundle("shengsiyuan",Locale.US);     //配置文件放在src目录下
//		String value=bundle.getString("hello");
//		System.out.println(value);
		
		System.out.println(Locale.getDefault());
		ResourceBundle bundle=ResourceBundle.getBundle("shengsiyuan",Locale.CHINA);     //配置文件放在src目录下
		String value=bundle.getString("hello");
		String result=MessageFormat.format(value, new Object[]{"shengsiyuan"});
		System.out.println(result);
		
		
		
	}
}
