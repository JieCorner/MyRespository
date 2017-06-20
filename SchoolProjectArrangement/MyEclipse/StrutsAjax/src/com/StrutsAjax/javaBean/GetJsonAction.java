package com.StrutsAjax.javaBean;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class GetJsonAction extends ActionSupport {
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
		people.setName(name);
		people.setAge(30);
		people.setAddress("beijing");
//		
		Gson gson=new Gson();
		String result=gson.toJson(people);
		System.out.println(result);
		HttpServletResponse response=ServletActionContext.getResponse();
//		
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		PrintWriter out=response.getWriter();
		out.write(result);
		
		out.flush();
		out.close();
		return null;
	}
	
}
