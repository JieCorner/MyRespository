package com.javaIOoperation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author jie
 * @action:
 * @time:2015��12��25��
 */
public class InputReadOperate
{
	//ԭʼ���Ͱ�װ��DataOutputStream
	//ByteArrayInputStream�ֽ�����������
	//CharArrayReader�ַ�����������
	
	
	// �����������֣�����int���ͣ�
	static public int getinputInt()
	{
		Scanner c = new Scanner(System.in);
		String str = c.nextLine();
		return Integer.parseInt(str);
	}
	
	// ��ӡ�������������Ϣ�ķ���Ҳ����д��,�൱��OutputStream.write();
	static public PrintWriter getPrintWriter(OutputStream out)
	{
		PrintWriter pw = new PrintWriter(out, true);
		return pw;
		// ʹ�÷�����pw.println(MSG);
	}
}
