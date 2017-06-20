package com.hibernate.twoway.otoo.operator;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.twoway.otoo.bean.IdCard;
import com.hibernate.twoway.otoo.bean.Student;
import com.hibernate.util.HibernateUtil;

public class OneToOneSaveTest {
	public static void main(String[] args) {
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Student student=new Student();
			student.setName("first");
			
			IdCard idcard=new IdCard();
			idcard.setNumber(1);
			
			student.setIdCard(idcard);
			idcard.setStudent(student);
			
			session.save(student);
			
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
