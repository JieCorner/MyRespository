package com.XMLTest;

import java.io.File;
import java.io.StringReader;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.io.SAXReader;

public class DOM4JTest2        //ʹ��DOM4J����XML
{
	
	public static void main(String[] args) throws Exception
	{
		//saxReader.read(new StringReader(xml))����ͨ��String��ʽ��xml���document����
		SAXReader saxReader=new SAXReader();
		Document doc=saxReader.read(new File("student2.xml"));
		Element root=doc.getRootElement();
		System.out.println("root element:"+root.getName());
		List childList=root.elements();
		System.out.println(childList.size());
		//��ȡ�ض����Ե�ֵ
		Element first=root.element("hello");
		System.out.println(first.attributeValue("age"));
		System.out.println("---------------------");
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=dbf.newDocumentBuilder();
		//����org.w3c.dom.Document��DOMTest1����org.dom4j.Document
		org.w3c.dom.Document document=db.parse(new File("student2.xml"));
		DOMReader domReader=new DOMReader();
		Document d=domReader.read(document);
		Element rootElement=d.getRootElement();
		System.out.println(rootElement.getName());
	}
}
