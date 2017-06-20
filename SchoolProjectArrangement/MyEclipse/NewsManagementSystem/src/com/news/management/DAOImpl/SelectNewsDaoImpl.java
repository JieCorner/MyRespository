package com.news.management.DAOImpl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.news.management.DAO.SelectNewsDAO;
import com.news.management.bean.News;

public class SelectNewsDaoImpl implements SelectNewsDAO{
	private HibernateTemplate hibernatetemplate;

	public HibernateTemplate getHibernatetemplate() {
		return hibernatetemplate;
	}

	public void setHibernatetemplate(HibernateTemplate hibernatetemplate) {
		this.hibernatetemplate = hibernatetemplate;
	}

	@Override
	public List<News> getNewslistBySelect(String title) {
		title="%"+title+"%";
		List<News> newlist=(List<News>) hibernatetemplate.find("from News as n where n.title like ?", title);
		return newlist;
	}
	
	
}
