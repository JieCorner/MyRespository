package com.StrutsAjax.javaBean;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.opensymphony.xwork2.ActionSupport;

public class GetXMLAction extends ActionSupport {
	
	private String name;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String execute() throws Exception {
		
		
		People people=new People();
		people.setId(1);
		people.setName("zhangsan");
		people.setAge(30);
		people.setAddress("beijing");
		
		People people2=new People();
		people2.setId(2);
		people2.setName("lisi");
		people2.setAge(50);
		people2.setAddress("tianjin");
		
		Document document=DocumentHelper.createDocument();
		Element rootElement=document.addElement("persons");
		rootElement.addComment("This is comment!");
		Element e=rootElement.addElement("person");
		Element idElement=e.addElement("id");
		Element nameElement=e.addElement("name");
		Element ageElement=e.addElement("age");
		Element addressElement=e.addElement("address");
		
		if("zhangsan".equals(name)){
			idElement.setText(people.getId()+"");
			nameElement.setText(people.getName());
			ageElement.setText(people.getAge()+"");
			addressElement.setText(people.getAddress());
		}
		else{
			idElement.setText(people2.getId()+"");
			nameElement.setText(people2.getName());
			ageElement.setText(people2.getAge()+"");
			addressElement.setText(people2.getAddress());
		}
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		
		PrintWriter out=response.getWriter();
		OutputFormat format=OutputFormat.createCompactFormat();
		format.setEncoding("utf-8");
		XMLWriter writer=new XMLWriter(out,format);
		writer.write(document);
		out.flush();
		out.close();
		return null;
	}
	
}
