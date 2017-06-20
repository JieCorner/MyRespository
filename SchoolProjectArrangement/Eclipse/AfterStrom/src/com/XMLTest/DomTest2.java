package com.XMLTest;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomTest2
{
	public static void main(String[] args) throws Exception
	{
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=dbf.newDocumentBuilder();
		Document doc=db.parse(new File("F:/java/XML/BaiduPicture/student.xml"));
		Element root=doc.getDocumentElement();
		System.out.println(root.getTagName());
		NodeList list=root.getChildNodes();
		//结果为7
		System.out.println(list.getLength());
		//输出里面内容
		for(int i=0;i<list.getLength();i++)
		{
			System.out.println(list.item(i).getNodeName());
		}
		System.out.println("---------------");
		for(int i=0;i<list.getLength();i++)
		{
			Node n=list.item(i);
			System.out.println(n.getTextContent());
		}
		System.out.println("---------------");
		NodeList nodelist=doc.getElementsByTagName("学生");
		System.out.println(nodelist.getLength());
		System.out.println("---------------");
		//获取属性，与NamedNodeMap有关
		for(int i=0;i<nodelist.getLength();i++)
		{
			NamedNodeMap nnm=nodelist.item(i).getAttributes();
			String attrName=nnm.item(0).getNodeName();  //第一个属性名
			System.out.print(attrName);
			System.out.print("=");
			String attrValue=nnm.item(0).getNodeValue(); //第一个属性值
			System.out.println(attrValue);
		}
	}
}
