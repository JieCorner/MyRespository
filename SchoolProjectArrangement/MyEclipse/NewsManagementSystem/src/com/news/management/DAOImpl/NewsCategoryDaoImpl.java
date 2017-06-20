package com.news.management.DAOImpl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.news.management.DAO.NewsCategoryDAO;
import com.news.management.bean.NewsCategory;
import com.news.management.bean.User;

public class NewsCategoryDaoImpl implements NewsCategoryDAO{
	private HibernateTemplate hibernatetemplate;
	public HibernateTemplate getHibernatetemplate() {
		return hibernatetemplate;
	}
	public void setHibernatetemplate(HibernateTemplate hibernatetemplate) {
		this.hibernatetemplate = hibernatetemplate;
	}
	@Override
	public void addNewsCategory(NewsCategory newsCategory) {
		// TODO Auto-generated method stub
		hibernatetemplate.save(newsCategory);
	}
	@Override
	public boolean ExistCategory(String CategoryName) {
		// TODO Auto-generated method stub
		List<NewsCategory> categorylist=(List<NewsCategory>) this.hibernatetemplate.find("from NewsCategory where newsCategoryName = ?",CategoryName);
		if(categorylist.size()==0){
			return true;//不存在(可以添加)
		}else{
			return false;//存在(不可以添加)
		}
	}
	@Override
	public List<NewsCategory> getCategoryList() {
		// TODO Auto-generated method stub
		List<NewsCategory> categorylist=(List<NewsCategory>) this.hibernatetemplate.find("from NewsCategory");
		return categorylist;
	}
	@Override
	public void deleteNewsCategory(int id) {
		// TODO Auto-generated method stub
		NewsCategory deleteCategory=hibernatetemplate.get(NewsCategory.class, id);
		hibernatetemplate.delete(deleteCategory);
	}
	@Override
	public NewsCategory getNewsCategoryById(int id) {
		// TODO Auto-generated method stub
		return hibernatetemplate.get(NewsCategory.class, id);
	}
	@Override
	public void updateNewsCategory(NewsCategory newsCategory) {
		// TODO Auto-generated method stub
		hibernatetemplate.update(newsCategory);
	}
	
}
