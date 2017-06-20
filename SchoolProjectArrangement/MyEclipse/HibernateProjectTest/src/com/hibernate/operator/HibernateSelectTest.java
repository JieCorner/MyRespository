package com.hibernate.operator;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.bean.People;
import com.hibernate.util.HibernateUtil;

public class HibernateSelectTest {
	public static void main(String[] args) {
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Query query=session.createQuery("from People where username='firstpeople'");
			List<People> list=(List<People>)query.list();
			for(Iterator<People> iter=list.iterator();iter.hasNext();){
				People people=(People)iter.next();
				System.out.println(people.getUsername());
				byte[] buffer=people.getFile();
				OutputStream os=new FileOutputStream("D:/"+people.getId()+".txt");
				os.write(buffer);
				os.close();
			}
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
