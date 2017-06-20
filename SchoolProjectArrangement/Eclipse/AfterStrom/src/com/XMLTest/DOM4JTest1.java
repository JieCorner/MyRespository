package com.XMLTest;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class DOM4JTest1          //使用DOM4J构建XML
{
	public static void main(String[] args) throws IOException
	{
		Element root=DocumentHelper.createElement("student");
		Document document=DocumentHelper.createDocument(root);
		root.addAttribute("name", "zhangsan");
		Element helloElement=root.addElement("hello");
		Element worldElement=root.addElement("world");
		helloElement.setText("hello");
		worldElement.setText("world");
		helloElement.addAttribute("age", "20");
		
		//输出构建完成的XML内容，还没有xml文件
		XMLWriter xmlWriter=new XMLWriter();
		xmlWriter.write(document);
		
		//将构建的XML内容生成一个xml文件(字节流)
		OutputFormat format=new OutputFormat("    ",true);
		XMLWriter xmlWriter2=new XMLWriter(new FileOutputStream("student2.xml"),format);
		xmlWriter2.write(document);
		
		//将构建的XML内容生成一个xml文件(字符流)
		XMLWriter xmlWriter3=new XMLWriter(new FileWriter("student3.xml"),format);
		xmlWriter3.write(document);
		xmlWriter3.flush();
		
	}
}
