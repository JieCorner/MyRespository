package com.hibernate.operator;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.bean.People;
import com.hibernate.util.HibernateUtil;

public class HibernateGetTest {
	public static void main(String[] args) {
		People people=null;
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		try{
			people=(People)session.get(People.class, new Long(1));
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(null!=tx){
				tx.rollback();
			}
		}finally{
			HibernateUtil.close(session);
		}
		System.out.println(people.getUsername());
	}
}
