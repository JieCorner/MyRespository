package com.news.management.DAOImpl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.news.management.DAO.UserDAO;
import com.news.management.bean.User;

public class UserDAOImpl implements UserDAO {

	private HibernateTemplate hibernatetemplate;
	
	public HibernateTemplate getHibernatetemplate() {
		return hibernatetemplate;
	}

	public void setHibernatetemplate(HibernateTemplate hibernatetemplate) {
		this.hibernatetemplate = hibernatetemplate;
	}

	@Override
	public void add(User user) {
		this.hibernatetemplate.save(user);
	}

	@Override
	public boolean getUserByName(String username) {
		// TODO Auto-generated method stub
		List<User> userlist=(List<User>) this.hibernatetemplate.find("from User where username = ?",username);
		if(userlist.size()==0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public User LoginOfUserExist(String username, String password) {
		// TODO Auto-generated method stub
		List<User> userlist=(List<User>) this.hibernatetemplate.find("from User where username = ? and password = ?", username,password);
		if(userlist.size()==1){
			//判断是否为管理员
			User user=userlist.get(0);
			return user;
		}else{
			return null;
		}
	}

	@Override
	public User getUserByID(int uid) {
		// TODO Auto-generated method stub
		return this.hibernatetemplate.get(User.class, uid);
	}

	@Override
	public void UpdateUser(User user) {
		// TODO Auto-generated method stub
		this.hibernatetemplate.update(user);
	}
	
}
