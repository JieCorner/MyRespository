package com.hibernate.twoway.otoo.operator;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.twoway.otoo.bean.Student;
import com.hibernate.util.HibernateUtil;

public class OneToOneGetTest {
	public static void main(String[] args) {
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		Student student=null;
		try{
			student=(Student)session.get(Student.class, "402809815adcb2d4015adcb2d4dd0001");
			session.delete(student);
			
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
