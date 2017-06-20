package com.hibernate.annotation.midtable.mtom.operator;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.annotation.midtable.mtom.bean.TableCat;
import com.hibernate.annotation.midtable.mtom.bean.TableMaster;
import com.hibernate.annotation.util.AnnotationHibernateUnit;

public class AnnotationTableMToMSaveTest {
	public static void main(String[] args) {
		Session session=AnnotationHibernateUnit.openSession();
		Transaction tx=session.beginTransaction();
		try{
			TableCat cat1=new 	TableCat();
			TableCat cat2=new 	TableCat();
			TableMaster master=new TableMaster();
			
			cat1.setName("cat1");
			cat2.setName("cat2");
			cat1.setMaster(new HashSet());
			cat2.setMaster(new HashSet());
			
			cat1.getMaster().add(master);
			cat2.getMaster().add(master);
			
			
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
