package com.hibernate.test;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.news.management.bean.News;
import com.news.management.bean.NewsCategory;
import com.news.management.bean.User;

public class JTest {
	@Test
	public void testAdd() throws Exception
	{	
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		try{
			
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtil.close(session);
		}
	}
	
	@Test
	public void testAdd2() throws Exception
	{	
		System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊".length());
		System.out.println();
	}
}
