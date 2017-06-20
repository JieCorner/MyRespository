package com.struts2.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {

	private int number;
	private String downfilename;
	
	
	
	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}



	public String getDownfilename() {
		return downfilename;
	}


	public void setDownfilename(String downfilename) {
		this.downfilename = downfilename;
	}


	public InputStream getDownloadFile() throws FileNotFoundException, UnsupportedEncodingException{
		if(number==1){
			this.setDownfilename("MyEclipse快捷键.txt");
			this.downfilename=new String(this.downfilename.getBytes("gbk"),"ISO-8859-1");
			return ServletActionContext.getServletContext().getResourceAsStream("/upload/MyEclipse快捷键.txt");
		}
		return null;
		
	}
	
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
}
