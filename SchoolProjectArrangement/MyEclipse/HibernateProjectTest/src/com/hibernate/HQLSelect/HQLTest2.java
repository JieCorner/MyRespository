package com.hibernate.HQLSelect;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.twoway.otom.bean.Customer;
import com.hibernate.twoway.otom.bean.Order;
import com.hibernate.util.HibernateUtil;

public class HQLTest2 {
	public static void main(String[] args) {
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Customer customer=(Customer)session.get(Customer.class, new Long(2));
			
			Query query=session.createQuery("from Order o where o.customer=:customer");
//			query.setParameter("customer", customer, Hibernate.entity(Customer.class));
			query.setEntity("customer", customer);
			
			
			List list=query.list();
			for(Iterator iter=list.iterator();iter.hasNext();){
				Order order=(Order)iter.next();
				System.out.println(order.getId()+":"+order.getOrdername());
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
