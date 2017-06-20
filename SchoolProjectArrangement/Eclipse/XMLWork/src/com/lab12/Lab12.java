package com.lab12;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Lab12
{
	public static void main(String[] args) throws DocumentException
	{
		SAXReader saxReader=new SAXReader();
		Document doc=saxReader.read(new File("src/student1_dom4j.xml"));
		Element root=doc.getRootElement();
		parseAttr(root,"学校");
		List childList=root.elements();
		Element student=(Element)childList.get(0);
		parseAttr(student,"年级");
		parseAttr(student,"学号");
		parseAllAttr(student);
	}
	public static void parseAllAttr(Element el){
		List list=el.elements();
		for(Object e:list){
			System.out.println(((Element)e).getName()+"-->"+((Element)e).getText());
		}
	}
	public static void parseAttr(Element el,String attname){
		System.out.println(el.getName()+"元素的学校属性值为"+el.attributeValue(attname));
	}
	
}
