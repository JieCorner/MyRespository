package com.hibernate.twoway.otoo.operator;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.twoway.otoo.bean.IdCard;
import com.hibernate.twoway.otoo.bean.Student;
import com.hibernate.util.HibernateUtil;

public class OfOneToOneDeleteTest {
	public static void main(String[] args) {
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Student Idcard=(Student)session.get(Student.class, "402809815adcdeb8015adcdeb8ef0001");
			session.delete(Idcard);
			
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
