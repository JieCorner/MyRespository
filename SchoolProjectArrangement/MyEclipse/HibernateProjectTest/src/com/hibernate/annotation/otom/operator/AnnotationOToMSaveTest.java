package com.hibernate.annotation.otom.operator;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.annotation.otom.bean.AnCat;
import com.hibernate.annotation.otom.bean.AnMaster;
import com.hibernate.annotation.util.AnnotationHibernateUnit;

public class AnnotationOToMSaveTest {
	public static void main(String[] args) {
		Session session=AnnotationHibernateUnit.openSession();
		Transaction tx=session.beginTransaction();
		try{
			AnCat cat1=new 	AnCat();
			AnCat cat2=new 	AnCat();
			AnMaster master=new AnMaster();
			
			cat1.setName("cat1");
			cat2.setName("cat2");
			cat1.setMaster(master);
			cat2.setMaster(master);
			
			master.setName("me");
			master.setCats(new HashSet());
			master.getCats().add(cat1);
			master.getCats().add(cat2);
			
			session.save(master);
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
