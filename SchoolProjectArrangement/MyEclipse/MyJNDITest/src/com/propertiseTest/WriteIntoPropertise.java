package com.propertiseTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class WriteIntoPropertise {
	//д�������ļ�
	public static void main(String[] args) {
		
	}
	public static void WriteProperties (String filePath, String pKey, String pValue) throws IOException {
		Properties pps = new Properties();
		InputStream in = new FileInputStream(filePath);
		//���������ж�ȡ�����б�����Ԫ�ضԣ� 
		pps.load(in);
		//���� Hashtable �ķ��� put��ʹ�� getProperty �����ṩ�����ԡ�  
		//ǿ��Ҫ��Ϊ���Եļ���ֵʹ���ַ���������ֵ�� Hashtable ���� put �Ľ����
		OutputStream out = new FileOutputStream(filePath);
		pps.setProperty(pKey, pValue);
		//���ʺ�ʹ�� load �������ص� Properties ���еĸ�ʽ��  
		//���� Properties ���е������б�����Ԫ�ضԣ�д�������  
		pps.store(out, "Update " + pKey + " name");
	}
}
