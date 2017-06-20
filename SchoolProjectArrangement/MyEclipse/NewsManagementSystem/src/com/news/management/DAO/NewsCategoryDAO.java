package com.news.management.DAO;

import java.util.List;

import com.news.management.bean.NewsCategory;

public interface NewsCategoryDAO {
	public void addNewsCategory(NewsCategory newsCategory);
	public boolean ExistCategory(String CategoryName);
	public List<NewsCategory> getCategoryList();
	public void deleteNewsCategory(int id);
	public NewsCategory getNewsCategoryById(int id);
	public void updateNewsCategory(NewsCategory newsCategory);
}
