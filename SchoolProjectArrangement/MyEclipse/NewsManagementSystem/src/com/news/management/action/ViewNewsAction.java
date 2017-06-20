package com.news.management.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;

import com.news.management.bean.Comment;
import com.news.management.bean.CommentPojo;
import com.news.management.bean.News;
import com.news.management.service.NewsService;
import com.opensymphony.xwork2.ActionSupport;

public class ViewNewsAction extends ActionSupport {

	private NewsService newsService;
	private News news;
	private List<Comment> commentlist;
	private int startlist;
	private int endlist;
	private List<CommentPojo> commentpojolist=new ArrayList();
	
	public List<CommentPojo> getCommentpojolist() {
		return commentpojolist;
	}
	public void setCommentpojolist(List<CommentPojo> commentpojolist) {
		this.commentpojolist = commentpojolist;
	}
	public int getStartlist() {
		return startlist;
	}
	public void setStartlist(int startlist) {
		this.startlist = startlist;
	}
	public int getEndlist() {
		return endlist;
	}
	public void setEndlist(int endlist) {
		this.endlist = endlist;
	}
	public List<Comment> getCommentlist() {
		return commentlist;
	}
	public void setCommentlist(List<Comment> commentlist) {
		this.commentlist = commentlist;
	}
	public NewsService getNewsService() {
		return newsService;
	}
	@Autowired
	public void setNewsService(@Qualifier("newsService")NewsService newsService) {
		this.newsService = newsService;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		news=newsService.getNews(news.getNumberId());
		HttpServletRequest request=ServletActionContext. getRequest();
		request.setAttribute("NEWSCONTENT", news.getContent());
		return SUCCESS;
	}
	public String UserViewNews() throws Exception {
		// TODO Auto-generated method stub
		news=newsService.getNews(news.getNumberId());
		HttpServletRequest request=ServletActionContext. getRequest();
		request.setAttribute("NEWSCONTENT", news.getContent());
		int viewtime=news.getViewtimes()+1;
		news.setViewtimes(viewtime);
		newsService.updateNews(news);
		return SUCCESS;
	}
	public String getCommentLists() throws Exception {
		// TODO Auto-generated method stub进行 分页返回
		news=newsService.getNews(news.getNumberId());
		commentlist=newsService.getNewsComment(news.getNumberId());
		commentlist=commentlist.subList(startlist-1, endlist);
		for(int i=0;i<commentlist.size();i++){
			CommentPojo commentpojo=new CommentPojo();
			commentpojo.setComment(commentlist.get(i));
			commentpojo.setIndex(startlist-1+i);
			commentpojolist.add(commentpojo);
		}
//		System.out.println(commentpojolist);
		return SUCCESS;
	}
}
