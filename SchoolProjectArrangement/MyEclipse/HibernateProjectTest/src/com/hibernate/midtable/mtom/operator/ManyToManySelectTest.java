package com.hibernate.midtable.mtom.operator;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.midtable.mtom.bean.MMCourse;
import com.hibernate.midtable.mtom.bean.MMStudent;
import com.hibernate.util.HibernateUtil;

public class ManyToManySelectTest {
	public static void main(String[] args) {
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		try{
			MMStudent student=null;
			MMCourse course=null;
			course=(MMCourse)session.get(MMCourse.class,"402809815adfec59015adfec5a0d0002");
			System.out.println(course.getStudents());
			
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
