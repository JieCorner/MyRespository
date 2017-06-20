package com.hibernate.midtable.mtom.operator;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.midtable.mtom.bean.MMCourse;
import com.hibernate.midtable.mtom.bean.MMStudent;
import com.hibernate.util.HibernateUtil;

public class ManyTOManySaveTest {
	public static void main(String[] args) {
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		try{
			MMStudent student=new MMStudent();
			student.setName("firststudent");
			student.setCourses(new HashSet());
			
			MMCourse course=new MMCourse();
			course.setName("music");
			course.setStudents(new HashSet());
			
			student.getCourses().add(course);
			course.getStudents().add(student);
			
			session.save(course);
			
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
