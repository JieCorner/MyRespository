package com.hibernate.annotation.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class AnnotationHibernateUnit {
	private static SessionFactory sessionFactory;
	static{
		try{
			Configuration configuration = new AnnotationConfiguration().configure("hibernate.cfg.xml");  
			sessionFactory =configuration.buildSessionFactory(); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Session openSession(){
		return sessionFactory.openSession();  
	}
	
	public static void close(Session session){
		if(null!=session){
			session.clear();
		}
	}
}
