package com.news.management.DAO;

import java.util.List;

import com.news.management.bean.News;

public interface SelectNewsDAO {
	public List<News> getNewslistBySelect(String title);
}
