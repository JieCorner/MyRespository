package com.news.management.DAO;

import com.news.management.bean.Comment;
import com.news.management.bean.News;
import com.news.management.bean.User;

public interface CommentDAO {
	public void addComment(Comment comment);
	public News getNews(int id);
	public User getUserByID(int uid);
	public Comment getCommentByID(int cid);
	public void updateComment(Comment comment);
}
