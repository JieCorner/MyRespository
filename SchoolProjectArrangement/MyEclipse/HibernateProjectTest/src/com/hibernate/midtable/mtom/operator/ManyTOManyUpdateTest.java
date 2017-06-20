package com.hibernate.midtable.mtom.operator;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.midtable.mtom.bean.MMCourse;
import com.hibernate.midtable.mtom.bean.MMStudent;
import com.hibernate.util.HibernateUtil;

public class ManyTOManyUpdateTest {
	public static void main(String[] args) {
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		try{
			
			MMStudent student=(MMStudent)session.get(MMStudent.class,"402809815ae0085a015ae0085af00001");
			MMCourse course=(MMCourse)session.get(MMCourse.class,"402809815ae0088e015ae0088ef80002");
			
//			student.getCourses().add(course);
			course.getStudents().add(student);
			session.update(student);
			
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
