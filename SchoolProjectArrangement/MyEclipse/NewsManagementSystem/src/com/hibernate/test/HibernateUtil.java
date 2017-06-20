package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionfactory;
	static{
		try{
			sessionfactory=new Configuration().configure().buildSessionFactory();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Session openSession(){
		Session session=sessionfactory.openSession();
		return session;
	}
	
	public static void close(Session session){
		if(null!=session){
			session.clear();
		}
	}
}
