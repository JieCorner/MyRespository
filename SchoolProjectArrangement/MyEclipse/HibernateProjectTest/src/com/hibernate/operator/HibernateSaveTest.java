package com.hibernate.operator;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.bean.People;
import com.hibernate.util.HibernateUtil;

public class HibernateSaveTest {
	public static void main(String[] args) {
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		try{
			People people=new People();
			people.setUsername("firstpeople");
			people.setPassword("admin");
			people.setBirthday(Date.valueOf("2017-9-9"));
			InputStream is=new FileInputStream("D://mysql-init.txt");
			int length=is.available();
			byte[] buffer=new byte[length];
			is.read(buffer);
			people.setFile(buffer);
			session.save(people);
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
