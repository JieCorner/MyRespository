package com.XMLTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDOMTest2
{
	public static void main(String[] args) throws Exception, IOException
	{
		SAXBuilder builder=new SAXBuilder();
		Document doc=builder.build(new File("jdom.xml"));
		Element element=doc.getRootElement();
		System.out.print(element.getName());
		Element hello=element.getChild("hello");
		System.out.print(hello.getText());
		List list=hello.getAttributes();
		for(int i=0;i<list.size();i++)
		{
			Attribute attr=(Attribute)list.get(i);
			String attrName=attr.getName();
			String attrValue=attr.getValue();
			System.out.print(attrName+"="+attrValue);
		}
		hello.removeChild("world");         //修改的是读到内存的xml内容文档doc
		XMLOutputter out=new XMLOutputter(Format.getPrettyFormat().setIndent("  "));
		out.output(doc, new FileOutputStream("jdom2.xml"));
	}
}
