package com.hibernate.extend.operator;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.extend.bean.EPerson;
import com.hibernate.util.HibernateUtil;

public class ExtendsSelectTest {
	public static void main(String[] args) {
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Query query=session.createQuery("from com.hibernate.extend.bean.EPerson");
			List list=query.list();
			for(Iterator item=list.iterator();item.hasNext();){
				EPerson person=(EPerson)item.next();
				System.out.println(person);
			}
			
			
			
			
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtil.close(session);
		}
	}
}
