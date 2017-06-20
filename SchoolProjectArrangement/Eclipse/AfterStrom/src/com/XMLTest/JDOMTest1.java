package com.XMLTest;

import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Comment;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDOMTest1          //构建XML文件
{
	public static void main(String[] args) throws Exception, IOException
	{
		Document document=new Document();   //新建一个文档
		Element root=new Element("root");   //新建一个元素
		document.addContent(root);       //增加元素 
		Comment comment=new Comment("This is my comments");  //这是注释
		root.addContent(comment);
		Element e=new Element("hello");
		e.setAttribute("sohu","www.sohu.com");
		root.addContent(e);
		Element e2=new Element("world");
		Attribute attr=new Attribute("test","hehe");
		e2.setAttribute(attr);
		e.addContent(e2);
		//在world中添加一个aaa元素，有两个属性，内容为text content
		//下面都是针对e2这个节点，特殊之处(方法链的方式)
		e2.addContent(new Element("aaa").setAttribute("a","b")     //设置多个属性 
				.setAttribute("x","y")
				.setAttribute("gg","yy")
				.setText("text content"));      					//设置内容
		//设置格式，传参给XMLOutputter
		Format format=Format.getPrettyFormat();   
		format.setIndent("   ");
		
		XMLOutputter out =new XMLOutputter(format);     //新建流
		out.output(document,new FileOutputStream("jdom.xml"));    //生成文件
	}
}
