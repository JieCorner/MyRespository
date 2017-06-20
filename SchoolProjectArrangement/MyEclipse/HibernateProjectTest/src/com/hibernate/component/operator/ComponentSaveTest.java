package com.hibernate.component.operator;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.component.bean.AddrStudent;
import com.hibernate.component.bean.Address;
import com.hibernate.util.HibernateUtil;

public class ComponentSaveTest {
	public static void main(String[] args) {
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		try{
			AddrStudent student=new AddrStudent();
			Address address=new Address();
			
			student.setName("firstname");
			address.setHomeAddress("jinpu nanmen");
			address.setSchoolAddress("jinpu sanbao");
			
			student.setAddress(address);
			
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
