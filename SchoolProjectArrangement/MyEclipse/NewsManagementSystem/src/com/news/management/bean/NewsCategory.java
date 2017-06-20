package com.news.management.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NewsCategory {
	private int CategoryId;
	private String newsCategoryName;
	private Set<News> newslist=new HashSet<News>();
	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	public String getNewsCategoryName() {
		return newsCategoryName;
	}
	public void setNewsCategoryName(String newsCategoryName) {
		this.newsCategoryName = newsCategoryName;
	}
	public Set<News> getNewslist() {
		return newslist;
	}
	public void setNewslist(Set<News> newslist) {
		this.newslist = newslist;
	}
}
