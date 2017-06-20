package com.hibernate.twoway.otom.operator;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.twoway.otom.bean.Customer;
import com.hibernate.util.HibernateUtil;

public class OneToManyDeleteTest {
	public static void main(String[] args) {
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Customer customer=(Customer)session.get(Customer.class, new Long(1));
			session.delete(customer);
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
