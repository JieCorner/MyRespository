package com.news.management.DAOImpl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.news.management.DAO.NewsDAO;
import com.news.management.bean.Comment;
import com.news.management.bean.News;
import com.news.management.bean.NewsCategory;

public class NewsDAOImpl implements NewsDAO {
	private HibernateTemplate hibernatetemplate;
	
	public HibernateTemplate getHibernatetemplate() {
		return hibernatetemplate;
	}

	public void setHibernatetemplate(HibernateTemplate hibernatetemplate) {
		this.hibernatetemplate = hibernatetemplate;
	}

	@Override
	public List<NewsCategory> getCategoryList() {
		// TODO Auto-generated method stub
		List<NewsCategory> categorylist=(List<NewsCategory>) this.hibernatetemplate.find("from NewsCategory");
		return categorylist;
	}

	@Override
	public NewsCategory getCategoryById(int id) {
		// TODO Auto-generated method stub
		return hibernatetemplate.get(NewsCategory.class, id);
	}

	@Override
	public void addNews(News news) {
		// TODO Auto-generated method stub
		hibernatetemplate.save(news);
	}

	@Override
	public News getNews(int id) {
		// TODO Auto-generated method stub
		return hibernatetemplate.get(News.class, id);
	}

	@Override
	public void updateNews(News news) {
		// TODO Auto-generated method stub
		hibernatetemplate.update(news);
	}

	@Override
	public List<News> getNewsList() {
		// TODO Auto-generated method stub
		List<News> newslist=(List<News>) this.hibernatetemplate.find("from News");
		return newslist;
	}

	@Override
	public List<News> getNewsListByCategory(int cid) {
		// TODO Auto-generated method stub
		List<News> newslist=(List<News>) this.hibernatetemplate.find("from News as n where n.newscategory.CategoryId=?",cid);
		return newslist;
	}

	@Override
	public void deleteNews(News news) {
		// TODO Auto-generated method stub
		hibernatetemplate.delete(news);
	}

	@Override
	public List<Comment> getNewsComment(int nid) {
		// TODO Auto-generated method stub
		List<Comment> newslist=(List<Comment>) this.hibernatetemplate.find("from Comment as c where c.news.NumberId=?",nid);
		return newslist;
	}

}
