package com.struts2.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ManyUploadAction extends ActionSupport {

	private String username;
	private List<File> files;
	private List<String> filesFileName;
	private List<String> filesContentType;
	
	public List<String> getFilesFileName() {
		return filesFileName;
	}


	public void setFilesFileName(List<String> filesFileName) {
		this.filesFileName = filesFileName;
	}


	public List<String> getFilesContentType() {
		return filesContentType;
	}


	public void setFilesContentType(List<String> filesContentType) {
		this.filesContentType = filesContentType;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public List<File> getFiles() {
		return files;
	}


	public void setFiles(List<File> files) {
		this.files = files;
	}


	@Override
	public String execute() throws Exception {
		
		for(int i=0;i<files.size();i++){
			String root=ServletActionContext.getRequest().getRealPath("/upload");
			InputStream is=new FileInputStream(files.get(i));
			File destFile=new File(root,filesFileName.get(i));
			OutputStream os=new FileOutputStream(destFile);
			byte[] buffer=new byte[400];
			int length=0;
			while(-1!=(length=is.read(buffer))){
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();
		}
		
		return SUCCESS;
	}
	
}
