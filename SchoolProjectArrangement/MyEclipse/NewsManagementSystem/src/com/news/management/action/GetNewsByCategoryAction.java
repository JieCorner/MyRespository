package com.news.management.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.news.management.bean.News;
import com.news.management.service.NewsService;
import com.opensymphony.xwork2.ActionSupport;

public class GetNewsByCategoryAction extends ActionSupport {
	private NewsService newsService;
	private List<News> newslist;
	private int categoryId;
	private String categoryName;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public List<News> getNewslist() {
		return newslist;
	}
	public void setNewslist(List<News> newslist) {
		this.newslist = newslist;
	}
	public NewsService getNewsService() {
		return newsService;
	}
	@Autowired
	public void setNewsService(@Qualifier("newsService")NewsService newsService) {
		this.newsService = newsService;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		newslist=newsService.getNewsListByCategory(categoryId);
		categoryName=newsService.getCategoryById(categoryId).getNewsCategoryName();
		return SUCCESS;
	}
	
}
