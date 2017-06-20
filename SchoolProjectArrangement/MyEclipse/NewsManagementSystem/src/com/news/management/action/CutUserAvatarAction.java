package com.news.management.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.news.management.bean.CutPicture;
import com.opensymphony.xwork2.ActionSupport;

public class CutUserAvatarAction extends ActionSupport {
	private String username;
	private int dataX;
	private int dataY;
	private int dataWidth;
	private int dataHeight;
	public Map responseJson;
	public Map getResponseJson() {
		return responseJson;
	}
	public void setResponseJson(Map responseJson) {
		this.responseJson = responseJson;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getDataX() {
		return dataX;
	}
	public void setDataX(int dataX) {
		this.dataX = dataX;
	}
	public int getDataY() {
		return dataY;
	}
	public void setDataY(int dataY) {
		this.dataY = dataY;
	}
	public int getDataWidth() {
		return dataWidth;
	}
	public void setDataWidth(int dataWidth) {
		this.dataWidth = dataWidth;
	}
	public int getDataHeight() {
		return dataHeight;
	}
	public void setDataHeight(int dataHeight) {
		this.dataHeight = dataHeight;
	}
	@Override
	public String execute() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		
		String name ="E:/NewsUpdateAvatar"+"\\"+username+".jpg";  
		try{
			CutPicture o = new CutPicture(dataX, dataY, dataWidth, dataHeight);  
		    o.setSrcpath(name);  
		    o.setSubpath(name);  
		    o.cut(); 
		    map.put("requestResult", "success");
		}catch(Exception e){
			map.put("requestResult", "fail");
		}
		this.setResponseJson(map);
		return SUCCESS;
		
	}
	
	
}
