package com.demo.daoImpl;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.demo.bean.User;
import com.demo.dao.UserDAO;


public class UserDAOImpl implements UserDAO {

	private HibernateTemplate hibernatetemplate;
	
	public HibernateTemplate getHibernatetemplate() {
		return hibernatetemplate;
	}

	public void setHibernatetemplate(HibernateTemplate hibernatetemplate) {
		this.hibernatetemplate = hibernatetemplate;
	}

	public void add() {
		User user=new User();
		user.setUsername("first People");
		user.setAddress("GuangDong GuangZhou");
		this.hibernatetemplate.save(user);
	}
}
