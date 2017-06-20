package com.XMLTest;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXTest1
{
	//SAX解析
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
	{
		//step1:获得SAX解析器工厂实例
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//step2:获得SAX解析器实例
		SAXParser parser=factory.newSAXParser();
		//step3:开始进行解析
		parser.parse(new File("F:/java/XML/BaiduPicture/student.xml"),new MyHandler());
	}
}
class MyHandler extends DefaultHandler{

	@Override
	public void startDocument() throws SAXException
	{
		System.out.println("parse began");
	}

	@Override
	public void endDocument() throws SAXException
	{
		System.out.println("parse finished");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException
	{
		System.out.println("start element");
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException
	{
		System.out.println("finish element");
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException
	{
		System.out.println("读数据");
	}
	
}
