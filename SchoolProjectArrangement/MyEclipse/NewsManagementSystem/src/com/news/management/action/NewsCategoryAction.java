package com.news.management.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.news.management.bean.NewsCategory;
import com.news.management.service.NewsCategoryService;
import com.opensymphony.xwork2.ActionSupport;

public class NewsCategoryAction extends ActionSupport {
	private List<NewsCategory> categorylists;
	private NewsCategory category;
	private NewsCategoryService newscategoryService;
	
	public NewsCategoryService getNewscategoryService() {
		return newscategoryService;
	}
	@Autowired
	public void setNewscategoryService(@Qualifier("newsCategoryService")NewsCategoryService newscategoryService) {
		this.newscategoryService = newscategoryService;
	}
	public NewsCategory getCategory() {
		return category;
	}

	public void setCategory(NewsCategory category) {
		this.category = category;
	}

	public List<NewsCategory> getCategorylists() {
		return categorylists;
	}
	public void setCategorylists(List<NewsCategory> categorylists) {
		this.categorylists = categorylists;
	}
	@Override
	public String execute() throws Exception {
		NewsCategory addcategory=new NewsCategory();
		addcategory.setNewsCategoryName(category.getNewsCategoryName());
		//增加类别
		newscategoryService.addNewsCategory(addcategory);
		return SUCCESS;
	}
	public void validateExecute() {
		if(category.getNewsCategoryName()==null||category.getNewsCategoryName().equals("")){
			this.addFieldError("category.newsCategoryName", "新闻类别名称不允许为空");
		}else if(newscategoryService.ExistCategory(category.getNewsCategoryName())){
			//验证是否存在
		}else{
			this.addFieldError("category.newsCategoryName", "该新闻类别已经存在,无需添加");
		}
	}
	//获得所有新闻类别
	public String getCategoryList() throws Exception {
		categorylists=newscategoryService.getCategoryList();
		return SUCCESS;
	}
	//获得更新新闻类别
	public String updateNewsCategory() throws Exception {
		category.setNewsCategoryName(newscategoryService.getNewsCategoryById(category.getCategoryId()).getNewsCategoryName());
		return SUCCESS;
	}
	//执行更新新闻类别
	public String updatedNewsCategory() throws Exception {
		NewsCategory getNewsCategory=newscategoryService.getNewsCategoryById(category.getCategoryId());
		getNewsCategory.setNewsCategoryName(category.getNewsCategoryName());
		newscategoryService.updateNewsCategory(getNewsCategory);
		return SUCCESS;
	}
	//删除新闻类别
	public String deleteNewsCategory() throws Exception {
		newscategoryService.deleteNewsCategory(category.getCategoryId());
		return SUCCESS;
	}
	
}
