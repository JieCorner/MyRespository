package com.XMLTest;

import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Comment;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDOMTest1          //����XML�ļ�
{
	public static void main(String[] args) throws Exception, IOException
	{
		Document document=new Document();   //�½�һ���ĵ�
		Element root=new Element("root");   //�½�һ��Ԫ��
		document.addContent(root);       //����Ԫ�� 
		Comment comment=new Comment("This is my comments");  //����ע��
		root.addContent(comment);
		Element e=new Element("hello");
		e.setAttribute("sohu","www.sohu.com");
		root.addContent(e);
		Element e2=new Element("world");
		Attribute attr=new Attribute("test","hehe");
		e2.setAttribute(attr);
		e.addContent(e2);
		//��world�����һ��aaaԪ�أ����������ԣ�����Ϊtext content
		//���涼�����e2����ڵ㣬����֮��(�������ķ�ʽ)
		e2.addContent(new Element("aaa").setAttribute("a","b")     //���ö������ 
				.setAttribute("x","y")
				.setAttribute("gg","yy")
				.setText("text content"));      					//��������
		//���ø�ʽ�����θ�XMLOutputter
		Format format=Format.getPrettyFormat();   
		format.setIndent("   ");
		
		XMLOutputter out =new XMLOutputter(format);     //�½���
		out.output(document,new FileOutputStream("jdom.xml"));    //�����ļ�
	}
}
