package com.spring1.daoimpl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.spring1.aop.Log;
import com.spring1.dao.LogDAO;

@Component("log")
public class LogDAOImpl implements LogDAO
{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}


	@Override
	public void savelog(Log log)
	{
		Session s=sessionFactory.getCurrentSession();
		s.save(log);
//		throw new RuntimeException("error");
	}
}
