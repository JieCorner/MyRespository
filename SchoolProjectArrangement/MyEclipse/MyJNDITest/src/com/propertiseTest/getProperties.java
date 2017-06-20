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
		//�����ļ���·��Ҫ��src��ʼ����Ϊ���������class��������ͬһ���ļ���
		 Properties pps = new Properties();
		InputStream in = new BufferedInputStream(new FileInputStream(".\\src\\com\\propertiseTest\\Test.properties"));
		pps.load(in);
		Enumeration en = pps.propertyNames(); //�õ������ļ�������
		while(en.hasMoreElements()) {
		String strKey = (String) en.nextElement();
		String strValue = pps.getProperty(strKey);
		System.out.println(strKey + "=" + strValue);
		 }
	}
}
