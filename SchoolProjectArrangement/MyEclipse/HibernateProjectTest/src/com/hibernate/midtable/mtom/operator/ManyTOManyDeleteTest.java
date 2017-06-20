package com.hibernate.midtable.mtom.operator;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.midtable.mtom.bean.MMCourse;
import com.hibernate.midtable.mtom.bean.MMStudent;
import com.hibernate.util.HibernateUtil;

public class ManyTOManyDeleteTest {
	public static void main(String[] args) {
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		try{
//			MMStudent student=(MMStudent)session.get(MMStudent.class, "402809815ae022b9015ae022ba410001");
//			session.delete(student);
			
			MMCourse course=(MMCourse)session.get(MMCourse.class, "402809815ae02825015ae02826910001");
			session.delete(course);
			
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
