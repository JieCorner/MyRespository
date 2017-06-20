package com.hibernate.extend.operator;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.extend.bean.EStudent;
import com.hibernate.extend.bean.ETeacher;
import com.hibernate.util.HibernateUtil;

public class ExtendsSaveTest {
	public static void main(String[] args) {
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		try{
			EStudent student=new EStudent();
			student.setCardId("123");
			student.setName("zhangzhang");
			
			ETeacher teacher=new ETeacher();
			teacher.setSalary("1000");
			teacher.setName("miaomiao");
			
			session.save(student);
			session.save(teacher);
			
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
