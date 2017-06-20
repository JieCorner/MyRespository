package com.lab13;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Lab13
{
	public static void main(String[] args) throws IOException
	{
		Element root=DocumentHelper.createElement("学生名册");
		Document document=DocumentHelper.createDocument(root);
		root.addAttribute("学校", "广州大学华软软件学院");
		Element stuElement=root.addElement("学生");
		
		stuElement.addAttribute("年级", "13级").addAttribute("学号", "13098765");
		Element nameElemnt=stuElement.addElement("姓名");
		
		nameElemnt.setText("仙人");
		Element sexeElement=stuElement.addElement("性别");
		sexeElement.setText("女");
		Element ageElement=stuElement.addElement("年龄");
		ageElement.setText("18");
		Element birElement=stuElement.addElement("生日");
		birElement.setText("2018-08-08");
		
		XMLWriter xmlWriter=new XMLWriter();
		xmlWriter.write(document);
		OutputFormat format=new OutputFormat("  ",true);
		XMLWriter xmlWriter2=new XMLWriter(new FileOutputStream("src/student1_dom4j.xml"));
		xmlWriter2.write(document);
		
		XMLWriter xmlWriter3=new XMLWriter(new FileWriter("src/student1_dom4j.xml"),format);
		xmlWriter3.write(document);
		
		xmlWriter3.flush();
		xmlWriter.close();
		xmlWriter2.close();
		xmlWriter3.close();

	}
}
