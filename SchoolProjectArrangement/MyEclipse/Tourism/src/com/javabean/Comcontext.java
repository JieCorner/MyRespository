package com.javabean;

public class Comcontext {
	private String username;
	private String context;
	private String publishdate;
	public Comcontext(String username,String context,String publishdate) {
		super();
		this.publishdate=publishdate;
		this.username=username;
		this.context=context;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}
	
}
