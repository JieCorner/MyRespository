package com.news.management.bean;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class News {
	private int NumberId;
	private String content;
	private String title;
	private Timestamp time;
	private String picName;
	private String NewsSource;
	private int viewtimes;
	private NewsCategory newscategory;
	private Set<Comment> comments=new HashSet<Comment>();
	public int getNumberId() {
		return NumberId;
	}
	public void setNumberId(int numberId) {
		NumberId = numberId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public String getNewsSource() {
		return NewsSource;
	}
	public void setNewsSource(String newsSource) {
		NewsSource = newsSource;
	}
	public int getViewtimes() {
		return viewtimes;
	}
	public void setViewtimes(int viewtimes) {
		this.viewtimes = viewtimes;
	}
	public NewsCategory getNewscategory() {
		return newscategory;
	}
	public void setNewscategory(NewsCategory newscategory) {
		this.newscategory = newscategory;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	
}
