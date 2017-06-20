package com.news.management.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.news.management.bean.Comment;
import com.news.management.bean.News;
import com.news.management.bean.User;
import com.news.management.service.CommentService;
import com.news.management.service.NewsService;
import com.opensymphony.xwork2.ActionSupport;

public class CommentAction extends ActionSupport {
	public Map responseJson;
	private int userID;
	private int newsID;
	private Comment comment;
	private NewsService newsService;
	private CommentService commentService;
	public NewsService getNewsService() {
		return newsService;
	}
	@Autowired
	public void setNewsService(@Qualifier("newsService")NewsService newsService) {
		this.newsService = newsService;
	}
	public Map getResponseJson() {
		return responseJson;
	}
	public void setResponseJson(Map responseJson) {
		this.responseJson = responseJson;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getNewsID() {
		return newsID;
	}
	public void setNewsID(int newsID) {
		this.newsID = newsID;
	}
	public CommentService getCommentService() {
		return commentService;
	}
	@Autowired
	public void setCommentService(@Qualifier("commentService")CommentService commentService) {
		this.commentService = commentService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		if(userID==0){
			map.put("requestResult", "fail");
		}else{
			if(comment.getContext().length()>45){
				map.put("requestResult", "Commentlength");
			}else if(comment.getContext().trim().length()==0){
				map.put("requestResult", "Commentnull");
			}else{
				News getnews=commentService.getNewsById(newsID);
				User getuser=commentService.getUserByID(userID);
				comment.setNews(getnews);
				comment.setUser(getuser);
				commentService.addComment(comment);
				map.put("requestResult", "success");
			}
		}
		this.setResponseJson(map);  
		return SUCCESS;
	}
	
	public String markUpforComment() throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		Comment getComment=commentService.getCommentByID(comment.getId());
		getComment.setUptimes(getComment.getUptimes()+1);
		commentService.updateComment(getComment);
		map.put("requestUp","success");
		map.put("requestUptimes",String.valueOf(getComment.getUptimes()));
		this.setResponseJson(map);  
		return SUCCESS;
	}
	
	public String getCommentListpage() throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		List<Comment> commentlist=newsService.getNewsComment(newsID);
		map.put("CommentPage",String.valueOf(commentlist.size()));
		this.setResponseJson(map);  
		return SUCCESS;
	}
}
