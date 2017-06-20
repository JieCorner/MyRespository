package com.XMLTest;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DomTest1            //树的结果模式
{
	public static void main(String[] args) throws Exception
	{
		//step1:获得dom解析器工厂（工厂的作用是用于创建具体的解析器）
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		//step2:获得具体的dom解析器
		DocumentBuilder db=dbf.newDocumentBuilder();
		//step3:解析一个xml文档，获得Document对象（根节点）
		Document document=db.parse(new File("F:/java/XML/BaiduPicture/first.xml"));
		
		NodeList list=document.getElementsByTagName("student");  //返回一个List
		for(int i=0;i<list.getLength();i++)
		{
			Element element=(Element)list.item(i);
			String content=element.getElementsByTagName("id").item(0).getFirstChild().getNodeValue();
			System.out.println("id："+content);
			content=element.getElementsByTagName("name").item(0).getFirstChild().getNodeValue();
			System.out.println("name："+content);
			content=element.getElementsByTagName("address").item(0).getFirstChild().getNodeValue();
			System.out.println("address："+content);
			System.out.println("--------------");
		}
	}
}
