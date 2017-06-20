package com.SSH.Integration.DAOImpl;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.SSH.Integration.DAO.UserDAO;
import com.SSH.Integration.bean.User;

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
