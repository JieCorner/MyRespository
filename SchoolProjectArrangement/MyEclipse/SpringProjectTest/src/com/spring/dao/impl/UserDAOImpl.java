package com.spring.dao.impl;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.spring.bean.User;
import com.spring.dao.UserDAO;

@Component("UserDaoImpl")
public class UserDAOImpl implements UserDAO {

	@Override
	public void save(User u) {
		System.out.println("a user saved");
	}

}
