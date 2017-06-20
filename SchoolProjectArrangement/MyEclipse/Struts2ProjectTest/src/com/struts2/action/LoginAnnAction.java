package com.struts2.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
@Namespace("/")
@Action(value="loginAnno",results=@Result(name="success",location="/index.jsp"))
public class LoginAnnAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
}
