package com.XMLTest;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXTest2
{
	public static void main(String[] args) throws ParserConfigurationException, SAXException, Exception
	{
		SAXParserFactory factory=SAXParserFactory.newInstance();
		SAXParser parser=factory.newSAXParser();
		parser.parse(new File("student.xml"),new MyHandler2());
	}
}
class MyHandler2 extends DefaultHandler{
	private Stack<String> stack=new Stack<String>();
	private String name;
	private String gender;
	private String age;
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException
	{
		stack.push(qName);
		for(int i=0;i<attributes.getLength();i++)//输出该元素的属性
		{
			String attrName=attributes.getQName(i);
			String attrValue=attributes.getValue(i);
			System.out.println(attrName+"="+attrValue);
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException
	{                                   //输出元素的子属性
		stack.pop();
		if("学生".equals(qName)){
			System.out.println("姓名："+name);
			System.out.println("性别："+gender);
			System.out.println("年龄："+age);
			System.out.println();
		}
	}
	@Override
	public void characters(char[] ch, int start, int length) //读标签里面内容的时候调用
			throws SAXException
	{                                //对变量进行赋值操作
		String tag=stack.peek();
		if("姓名".equals(tag))
		{
			name=new String(ch,start,length);
		}else if("性别".equals(tag)){
			gender=new String(ch,start,length);
		}
		else if("年龄".equals(tag))
		{
			age=new String(ch,start,length);
		}
	}
	
}