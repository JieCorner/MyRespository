package com.XMLTest;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DomTest1            //���Ľ��ģʽ
{
	public static void main(String[] args) throws Exception
	{
		//step1:���dom���������������������������ڴ�������Ľ�������
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		//step2:��þ����dom������
		DocumentBuilder db=dbf.newDocumentBuilder();
		//step3:����һ��xml�ĵ������Document���󣨸��ڵ㣩
		Document document=db.parse(new File("F:/java/XML/BaiduPicture/first.xml"));
		
		NodeList list=document.getElementsByTagName("student");  //����һ��List
		for(int i=0;i<list.getLength();i++)
		{
			Element element=(Element)list.item(i);
			String content=element.getElementsByTagName("id").item(0).getFirstChild().getNodeValue();
			System.out.println("id��"+content);
			content=element.getElementsByTagName("name").item(0).getFirstChild().getNodeValue();
			System.out.println("name��"+content);
			content=element.getElementsByTagName("address").item(0).getFirstChild().getNodeValue();
			System.out.println("address��"+content);
			System.out.println("--------------");
		}
	}
}
