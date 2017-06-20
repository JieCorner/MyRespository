package com.news.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.news.management.DAO.CommentDAO;
import com.news.management.bean.Comment;
import com.news.management.bean.News;
import com.news.management.bean.User;

@Transactional
@Component
public class CommentService {
	private CommentDAO commentDao;
	
	public CommentDAO getCommentDao() {
		return commentDao;
	}
	@Autowired
	public void setCommentDao(@Qualifier("CommentDAOImpl")CommentDAO commentDao) {
		this.commentDao = commentDao;
	}

	public void addComment(Comment comment){
		commentDao.addComment(comment);
	}
	
	public News getNewsById(int nid) {
		// TODO Auto-generated method stub
		return commentDao.getNews(nid);
	}
	
	public User getUserByID(int uid) {
		// TODO Auto-generated method stub
		return commentDao.getUserByID(uid);
	}
	
	public Comment getCommentByID(int cid) {
		// TODO Auto-generated method stub
		return commentDao.getCommentByID(cid);
	}
	
	public void updateComment(Comment comment){
		commentDao.updateComment(comment);
	}
}
