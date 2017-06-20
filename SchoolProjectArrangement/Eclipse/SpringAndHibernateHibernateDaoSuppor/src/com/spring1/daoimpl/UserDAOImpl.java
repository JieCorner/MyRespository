package com.spring1.daoimpl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.spring1.aop.User;
import com.spring1.dao.UserDAO;

@Component("u")
public class UserDAOImpl implements UserDAO
{
//	private SessionFactory sessionFactory;
//
//	public SessionFactory getSessionFactory()
//	{
//		return sessionFactory;
//	}
//	
//	@Resource
//	public void setSessionFactory(SessionFactory sessionFactory)
//	{
//		this.sessionFactory = sessionFactory;
//	}
	
//	@Override
//	public void save(User u)
//	{
//		try{
//			Session s=sessionFactory.getCurrentSession();
//			s.save(u);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate()
	{
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate)
	{
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(User u)
	{
		hibernateTemplate.save(u);
	}
	
	
}
