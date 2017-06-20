package com.news.management.DAOImpl;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.news.management.DAO.CommentDAO;
import com.news.management.bean.Comment;
import com.news.management.bean.News;
import com.news.management.bean.User;

public class CommentDaoImpl implements CommentDAO {
	private HibernateTemplate hibernatetemplate;
	
	public HibernateTemplate getHibernatetemplate() {
		return hibernatetemplate;
	}

	public void setHibernatetemplate(HibernateTemplate hibernatetemplate) {
		this.hibernatetemplate = hibernatetemplate;
	}

	@Override
	public void addComment(Comment comment) {
		// TODO Auto-generated method stub
		hibernatetemplate.save(comment);
	}

	@Override
	public News getNews(int id) {
		// TODO Auto-generated method stub
		return hibernatetemplate.get(News.class, id);
	}

	@Override
	public User getUserByID(int uid) {
		// TODO Auto-generated method stub
		return this.hibernatetemplate.get(User.class, uid);
	}

	@Override
	public Comment getCommentByID(int cid) {
		// TODO Auto-generated method stub
		return this.hibernatetemplate.get(Comment.class, cid);
	}

	@Override
	public void updateComment(Comment comment) {
		// TODO Auto-generated method stub
		this.hibernatetemplate.update(comment);
	}

}
