package com.hibernate.HQLSelect;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import sun.security.util.BigInt;

import com.hibernate.twoway.otom.bean.Order;
import com.hibernate.util.HibernateUtil;

public class HQLTest {
	public static void main(String[] args) {
		HQLTest.queryOrder(5, 3);
	}
	
	public static void queryOrder(int orderID,int customerID){
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Query query=session.createQuery("from Order as o where "+"o.id=:orderId"+" and o.customer.id=:customerId");
			query.setBigInteger("orderId", new BigInteger(new Integer(orderID).toString()));
			query.setBigInteger("customerId", new BigInteger(new Integer(customerID).toString()));
			List list=query.list();
			for(Iterator iter=list.iterator();iter.hasNext();){
				System.out.println(((Order)iter.next()).getOrdername());
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
