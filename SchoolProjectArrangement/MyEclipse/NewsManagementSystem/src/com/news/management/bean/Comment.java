package com.news.management.bean;

public class Comment {
	private int id;
	private User user;
	private String context;
	private News news;
	private int Uptimes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public int getUptimes() {
		return Uptimes;
	}
	public void setUptimes(int uptimes) {
		Uptimes = uptimes;
	}
	
}
