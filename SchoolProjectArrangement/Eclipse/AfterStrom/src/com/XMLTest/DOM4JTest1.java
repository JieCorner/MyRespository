package com.XMLTest;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class DOM4JTest1          //ʹ��DOM4J����XML
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
		
		//���������ɵ�XML���ݣ���û��xml�ļ�
		XMLWriter xmlWriter=new XMLWriter();
		xmlWriter.write(document);
		
		//��������XML��������һ��xml�ļ�(�ֽ���)
		OutputFormat format=new OutputFormat("    ",true);
		XMLWriter xmlWriter2=new XMLWriter(new FileOutputStream("student2.xml"),format);
		xmlWriter2.write(document);
		
		//��������XML��������һ��xml�ļ�(�ַ���)
		XMLWriter xmlWriter3=new XMLWriter(new FileWriter("student3.xml"),format);
		xmlWriter3.write(document);
		xmlWriter3.flush();
		
	}
}
