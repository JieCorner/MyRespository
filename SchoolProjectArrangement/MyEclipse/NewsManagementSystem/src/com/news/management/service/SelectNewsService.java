package com.news.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.news.management.DAO.SelectNewsDAO;
import com.news.management.bean.News;

@Transactional
@Component
public class SelectNewsService {
	private SelectNewsDAO selectNewsdao;

	public SelectNewsDAO getSelectNewsdao() {
		return selectNewsdao;
	}
	@Autowired
	public void setSelectNewsdao(@Qualifier("SelectNewsDAOImpl")SelectNewsDAO selectNewsdao) {
		this.selectNewsdao = selectNewsdao;
	}
	
	public List<News> getNewslistBySelect(String title) {
		return selectNewsdao.getNewslistBySelect(title);
	}
}
