package com.news.management.DAO;

import java.util.List;

import com.news.management.bean.Comment;
import com.news.management.bean.News;
import com.news.management.bean.NewsCategory;

public interface NewsDAO {
	public List<NewsCategory> getCategoryList();
	public NewsCategory getCategoryById(int id);
	public void addNews(News news);
	public News getNews(int id);
	public void updateNews(News news);
	public List<News> getNewsList();
	public List<News> getNewsListByCategory(int cid);
	public void deleteNews(News news);
	public List<Comment> getNewsComment(int nid);
}
