package com.news.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.news.management.DAO.NewsDAO;
import com.news.management.bean.Comment;
import com.news.management.bean.News;
import com.news.management.bean.NewsCategory;
@Transactional
@Component
public class NewsService {
	private NewsDAO newsDAO;

	public NewsDAO getNewsDAO() {
		return newsDAO;
	}
	@Autowired
	public void setNewsDAO(@Qualifier("NewsDAOImpl")NewsDAO newsDAO) {
		this.newsDAO = newsDAO;
	}
	
	public List<NewsCategory> getCategoryList(){
		return newsDAO.getCategoryList();
	}
	
	public NewsCategory getCategoryById(int id){
		return newsDAO.getCategoryById(id);
	}
	
	public void addNews(News news) {
		// TODO Auto-generated method stub
		newsDAO.addNews(news);
	}
	
	public News getNews(int id) {
		// TODO Auto-generated method stub
		return newsDAO.getNews(id);
	}
	
	public void updateNews(News news) {
		// TODO Auto-generated method stub
		newsDAO.updateNews(news);
	}
	
	public List<News> getNewsList() {
		return newsDAO.getNewsList();
	}
	
	public List<News> getNewsListByCategory(int cid) {
		return newsDAO.getNewsListByCategory(cid);
	}
	
	public void deleteNews(News news) {
		// TODO Auto-generated method stub
		newsDAO.deleteNews(news);
	}
	
	public List<Comment> getNewsComment(int nid){
		return newsDAO.getNewsComment(nid);
	}
}
