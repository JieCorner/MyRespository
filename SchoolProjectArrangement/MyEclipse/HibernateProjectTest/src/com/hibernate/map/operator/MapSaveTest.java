package com.hibernate.map.operator;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.map.bean.Team;
import com.hibernate.util.HibernateUtil;

public class MapSaveTest {
	public static void main(String[] args) {
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Team team=new Team();
			team.setTeamname("Fifty alerdy here");
			
			Map map=new HashMap();
			map.put("jie", "Group leader");
			map.put("faping", "Crew");
			
			team.setStudents(map);
			
			session.save(team);
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
