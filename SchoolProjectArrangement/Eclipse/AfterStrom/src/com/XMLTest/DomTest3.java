package com.XMLTest;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomTest3
{
	public static void main(String[] args) throws Exception
	{
		DocumentBuilderFactory bdf=DocumentBuilderFactory.newInstance();
		DocumentBuilder bd=bdf.newDocumentBuilder();
		Document doc=bd.parse(new File("F:/java/XML/BaiduPicture/student.xml"));
		//获得根节点
		Element root=doc.getDocumentElement();
		parseElement(root);
	}
//输出完整的XML文件
	private static void parseElement(Element element)
	{
		String tagName=element.getNodeName();
		NodeList children=element.getChildNodes();
		System.out.print("<"+tagName);
		NamedNodeMap map=element.getAttributes();
		//列出全部的属性和值
		if(null!=map)
		{
			for(int i=0;i<map.getLength();i++)
			{
				Attr attr=(Attr)map.item(i);
				String attrName=attr.getName();
				String attrValue=attr.getValue();
				System.out.print("  "+attrName+"=\""+attrValue+"\"");
			}
		}
		System.out.print(">");
		//输出全部的子元素
		for(int i=0;i<children.getLength();i++)
		{
			Node node=children.item(i);
			//获得结点的类型
			short nodeType =node.getNodeType();
			if(nodeType==Node.ELEMENT_NODE){
				//是元素，继续递归
				parseElement((Element)node);
			}else if(nodeType==Node.TEXT_NODE){
				//递归出口
				System.out.print(node.getNodeValue());
			}else if(nodeType==Node.COMMENT_NODE){
				System.out.print("<!--");
				Comment comment=(Comment)node;
				//注释内容
				String data=comment.getData();
				System.out.print(data);
				System.out.print("-->");
				
			}
		}
		System.out.print("</"+tagName+">");
	}
}
