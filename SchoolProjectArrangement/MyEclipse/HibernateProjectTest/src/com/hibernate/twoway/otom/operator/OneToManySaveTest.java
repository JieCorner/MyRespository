package com.hibernate.twoway.otom.operator;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.twoway.otom.bean.Customer;
import com.hibernate.twoway.otom.bean.Order;
import com.hibernate.util.HibernateUtil;

public class OneToManySaveTest {
	public static void main(String[] args) {
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Customer customer=new Customer();
			customer.setUsername("firstCustomer");
			customer.setOrders(new HashSet());
			
			Order order1=new Order();
			order1.setOrdername("order1");
			Order order2=new Order();
			order2.setOrdername("order2");
			
			order1.setCustomer(customer);
			order2.setCustomer(customer);
			
			customer.getOrders().add(order1);
			customer.getOrders().add(order2);
			
			session.save(customer);
			
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
