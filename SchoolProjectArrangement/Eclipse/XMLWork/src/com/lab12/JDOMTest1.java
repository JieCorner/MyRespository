package com.lab12;

import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Comment;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDOMTest1          
{
	public static void main(String[] args) throws Exception, IOException
	{
		Document document=new Document();   
		Element root=new Element("学生名册");   
		root.setAttribute("学校","广州大学华软软件学院");
		document.addContent(root);      

		Element e=new Element("学生");
		e.setAttribute("年级","09级");
		e.setAttribute("学号","b001");
		root.addContent(e);
		Element name=new Element("姓名");
		name.setText("张小二");
		Element sex=new Element("性别");
		sex.setText("男");
		Element age=new Element("年龄");
		age.setText("22");
		Element birthday=new Element("生日");
		birthday.setText("1991-10-24");
		e.addContent(name);
		e.addContent(sex);
		e.addContent(age);
		e.addContent(birthday);
		Format format=Format.getPrettyFormat();   
		XMLOutputter out =new XMLOutputter(format);    
		out.output(document,new FileOutputStream("jdom.xml"));  
	}
}
