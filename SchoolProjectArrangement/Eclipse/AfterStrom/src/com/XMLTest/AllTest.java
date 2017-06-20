package com.XMLTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class AllTest           
{
	public static void main(String[] args) throws Exception
	{
		 //通过DOM4J解析主要先获得document的rootElement
		//将xml转化为String，并通过获得的String重写构造成XML，并解析获得内容
		SAXReader saxReader=new SAXReader();
		Document doc=saxReader.read(new File("student.xml"));
		String xml=doc.asXML();     //可以说把这个xml转化为String
		System.out.println(xml);
		Document document = saxReader.read(new StringReader(xml));
		System.out.println("---------------------");
		System.out.println(document.getRootElement().element("学生").element("姓名").getText());
		System.out.println("---------------------");
		System.out.println("学生学号属性="+document.getRootElement().element("学生").attributeValue("学号"));
		System.out.println("---------------------");
		//自己生成XML文件
		Element root=DocumentHelper.createElement("家庭");
		Document doc1=DocumentHelper.createDocument(root);
		root.addAttribute("地址", "南门");
		Element father=root.addElement("父亲");
		Element mather=root.addElement("母亲");
		father.addAttribute("职务","工作");
		mather.addAttribute("职务","家务");
		father.setText("爸爸");
		mather.setText("妈妈");
		OutputFormat format=new OutputFormat("    ",true);
		XMLWriter xmlwrite=new XMLWriter(new FileOutputStream("MyFirstXML.xml"),format);
		xmlwrite.write(doc1);
	}
}
