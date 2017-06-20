package com.work;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;



public class WriteXML
{
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException
	{
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=dbf.newDocumentBuilder();
		Document doc=db.newDocument();
		doc.setXmlVersion("1.0");
		Comment comment=doc.createComment("创建xml文件");
		doc.appendChild(comment);
		Element root=doc.createElement("班级");
		Element stu=doc.createElement("学生");
		Element name=doc.createElement("姓名");
		Element sex=doc.createElement("性别");
		name.setTextContent("神仙姐姐");
		sex.setAttribute("sex", "女");
		stu.appendChild(name);
		stu.appendChild(sex);
		root.appendChild(stu);
		doc.appendChild(root);
		
		TransformerFactory factory1=TransformerFactory.newInstance();
		Transformer tformer=factory1.newTransformer();
		tformer.transform(new DOMSource(doc), new StreamResult("ds.xml"));
		
	}
}
