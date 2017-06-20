package com.hibernate.operator;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.bean.People;
import com.hibernate.util.HibernateUtil;

public class HibernatePageTest {
	public static void main(String[] args) {
		HibernatePageTest test=new HibernatePageTest();
		test.Pageshow(0, 2);
	}
	
	//分页显示 
	public void Pageshow(int start,int number){
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Query query=session.createQuery("from People as p order by p.id asc").setFirstResult(start).setMaxResults(number);
			List<People> list=(List<People>)query.list();
			for(Iterator<People> iter=list.iterator();iter.hasNext();){
				People people=(People)iter.next();
				System.out.println(people.getId());
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
