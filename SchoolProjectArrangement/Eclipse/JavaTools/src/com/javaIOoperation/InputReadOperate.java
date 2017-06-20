package com.javaIOoperation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author jie
 * @action:
 * @time:2015年12月25日
 */
public class InputReadOperate
{
	//原始类型包装类DataOutputStream
	//ByteArrayInputStream字节数组输入流
	//CharArrayReader字符数组输入流
	
	
	// 获得输入的数字（返回int类型）
	static public int getinputInt()
	{
		Scanner c = new Scanner(System.in);
		String str = c.nextLine();
		return Integer.parseInt(str);
	}
	
	// 打印输出流，用于信息的发送也可以写入,相当于OutputStream.write();
	static public PrintWriter getPrintWriter(OutputStream out)
	{
		PrintWriter pw = new PrintWriter(out, true);
		return pw;
		// 使用方法：pw.println(MSG);
	}
}
