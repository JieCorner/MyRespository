package com.hibernate.HQLSelect;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

import com.hibernate.twoway.otom.bean.Order;
import com.hibernate.util.HibernateUtil;

public class QBCTest {
	public static void main(String[] args) {
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Criteria criteria=session.createCriteria(Order.class);
			
			Criterion criterion1=Restrictions.like("ordername", "%2");
			Criterion criterion2=Restrictions.eq("id", new Long(4));
			
			criteria=criteria.add(criterion1);
			criteria=criteria.add(criterion2);
			List list=criteria.list();
			
			for(Iterator iter=list.iterator();iter.hasNext();){
				System.out.println(((Order)iter.next()).getCustomer().getId());
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
