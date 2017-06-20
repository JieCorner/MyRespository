package com.news.management.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.news.management.bean.News;
import com.news.management.service.SelectNewsService;
import com.opensymphony.xwork2.ActionSupport;

public class SelectNewsAction extends ActionSupport {
	private String selectNewBytitle;
	private SelectNewsService selectNewsservice;
	private List<News> newslistbyselect;
	public List<News> getNewslistbyselect() {
		return newslistbyselect;
	}

	public void setNewslistbyselect(List<News> newslistbyselect) {
		this.newslistbyselect = newslistbyselect;
	}

	public String getSelectNewBytitle() {
		return selectNewBytitle;
	}

	public void setSelectNewBytitle(String selectNewBytitle) {
		this.selectNewBytitle = selectNewBytitle;
	}

	public SelectNewsService getSelectNewsservice() {
		return selectNewsservice;
	}
	@Autowired
	public void setSelectNewsservice(@Qualifier("selectNewsService")SelectNewsService selectNewsservice) {
		this.selectNewsservice = selectNewsservice;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(selectNewBytitle);
		newslistbyselect=selectNewsservice.getNewslistBySelect(selectNewBytitle);
		return SUCCESS;
	}
	
}
