package com.hibernate.operator;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.bean.People;
import com.hibernate.util.HibernateUtil;

public class HibernateUpdateTest {
	public static void main(String[] args) {
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		try{
			People people=(People)session.get(People.class, new Long(1));
			people.setUsername("kaili");
			session.update(people);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(null!=tx){
				tx.rollback();
			}
		}finally{
			HibernateUtil.close(session);
		}
	}
}
