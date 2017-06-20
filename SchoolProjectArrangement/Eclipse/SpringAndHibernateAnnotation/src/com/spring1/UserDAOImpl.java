package com.spring1;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component("u")
public class UserDAOImpl implements UserDAO
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
	public void save(User u)
	{
		try{
			Session s=sessionFactory.openSession();
			s.beginTransaction();
			s.save(u);
			s.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
