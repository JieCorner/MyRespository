package com.hibernate.annotation.operator;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.annotation.bean.TStudent;
import com.hibernate.annotation.util.AnnotationHibernateUnit;

public class AnnotationTest {
	public static void main(String[] args) {
		Session session=AnnotationHibernateUnit.openSession();
		Transaction tx=session.beginTransaction();
		try{
			 TStudent student = new TStudent();  
		     student.setName("shishi");  
		     student.setPassword("123");
		     student.setAge(33);   
		     session.save(student);  
		     tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			AnnotationHibernateUnit.close(session);
		}
	}
}
