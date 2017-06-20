package com.news.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.news.management.DAO.NewsCategoryDAO;
import com.news.management.DAO.UserDAO;
import com.news.management.bean.NewsCategory;

@Transactional
@Component
public class NewsCategoryService {
	private NewsCategoryDAO newscategoryDAO;

	public NewsCategoryDAO getNewscategoryDAO() {
		return newscategoryDAO;
	}
	@Autowired
	public void setNewscategoryDAO(@Qualifier("NewsCategoryDaoImpl") NewsCategoryDAO newscategoryDAO) {
		this.newscategoryDAO = newscategoryDAO;
	}
	
	public void addNewsCategory(NewsCategory newsCategory) {
		newscategoryDAO.addNewsCategory(newsCategory);
	}
	public boolean ExistCategory(String CategoryName){
		return newscategoryDAO.ExistCategory(CategoryName);
	}
	
	public List<NewsCategory> getCategoryList() {
		return newscategoryDAO.getCategoryList();
	}
	
	public void deleteNewsCategory(int id) {
		// TODO Auto-generated method stub
		newscategoryDAO.deleteNewsCategory(id);
	}
	
	public NewsCategory getNewsCategoryById(int id) {
		// TODO Auto-generated method stub
		return newscategoryDAO.getNewsCategoryById(id);
	}
	
	public void updateNewsCategory(NewsCategory newsCategory){
		newscategoryDAO.updateNewsCategory(newsCategory);
	}
}
