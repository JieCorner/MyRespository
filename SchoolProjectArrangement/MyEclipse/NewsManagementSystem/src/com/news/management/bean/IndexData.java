package com.news.management.bean;

import java.util.List;

public class IndexData {
	private List<News> newslist;
	private List<NewsCategory> categorylist;
	
	public List<NewsCategory> getCategorylist() {
		return categorylist;
	}

	public void setCategorylist(List<NewsCategory> categorylist) {
		this.categorylist = categorylist;
	}

	public List<News> getNewslist() {
		return newslist;
	}

	public void setNewslist(List<News> newslist) {
		this.newslist = newslist;
	}

	

	
	
}
