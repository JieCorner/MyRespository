package com.news.management.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.news.management.bean.News;
import com.news.management.bean.NewsCategory;
import com.news.management.service.NewsService;
import com.opensymphony.xwork2.ActionSupport;

public class NewsAction extends ActionSupport {

	private NewsService newsService;
	private List<NewsCategory> categorylist;
	private News news;
	private int selectedcategoryID;
	private List<News> newslist;
	public List<News> getNewslist(){
		return newslist;
	}
	public void setNewslist(List<News> newslist) {
		this.newslist = newslist;
	}
	public int getSelectedcategoryID() {
		return selectedcategoryID;
	}
	public void setSelectedcategoryID(int selectedcategoryID) {
		this.selectedcategoryID = selectedcategoryID;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public NewsService getNewsService() {
		return newsService;
	}
	@Autowired
	public void setNewsService(@Qualifier("newsService")NewsService newsService) {
		this.newsService = newsService;
	}

	public List<NewsCategory> getCategorylist() {
		return categorylist;
	}
	public void setCategorylist(List<NewsCategory> categorylist) {
		this.categorylist = categorylist;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		NewsCategory getSelectCategory=newsService.getCategoryById(selectedcategoryID);
		news.setNewscategory(getSelectCategory);
		news.setTime(new Timestamp(new java.util.Date().getTime()));
		news.setPicName(getPicPath(news.getContent()));
		newsService.addNews(news);
		return SUCCESS;
	}
	
	public String getCategoryList() throws Exception {
		// TODO Auto-generated method stub
		categorylist=newsService.getCategoryList();
		return "list";
	}
	
	public String getPicPath(String htmlcode){
		List<String> imageSrcList = new ArrayList<String>();  
        Pattern p = Pattern.compile("<img\\b[^>]*\\bsrc\\b\\s*=\\s*('|\")?([^'\"\n\r\f>]+(\\.jpg|\\.bmp|\\.eps|\\.gif|\\.mif|\\.miff|\\.png|\\.tif|\\.tiff|\\.svg|\\.wmf|\\.jpe|\\.jpeg|\\.dib|\\.ico|\\.tga|\\.cut|\\.pic)\\b)[^>]*>", Pattern.CASE_INSENSITIVE);  
        Matcher m = p.matcher(htmlcode);  
        String quote = null;  
        String src = null;  
        while (m.find()) {  
            quote = m.group(1);  
            src = (quote == null || quote.trim().length() == 0) ? m.group(2).split("\\s+")[0] : m.group(2);  
            imageSrcList.add(src);  
        }  
        return imageSrcList.get(0); 
	}
	//获得更新的数据
	public String updateNews(){
		news=newsService.getNews(news.getNumberId());
		categorylist=newsService.getCategoryList();
		return SUCCESS;
	}
	//执行更新操作
	public String updatedNews(){
		//更新
		NewsCategory getSelectCategory=newsService.getCategoryById(selectedcategoryID);
		news.setNewscategory(getSelectCategory);
		news.setTime(new Timestamp(new java.util.Date().getTime()));
		news.setPicName(getPicPath(news.getContent()));
		System.out.println(news);
		newsService.updateNews(news);
		return SUCCESS;
	}
	
	public String getNewList(){
		categorylist=newsService.getCategoryList();
		newslist=newsService.getNewsList();
		return "list";
	}
	
	public String getNewListByCategory(){
		newslist=newsService.getNewsListByCategory(selectedcategoryID);
		categorylist=newsService.getCategoryList();
		return "list";
	}
	
	public String deleteNew(){
		News deleteNews=newsService.getNews(news.getNumberId());
		newsService.deleteNews(deleteNews);
		return SUCCESS;
	}
	
}
