package com.spring1.dao;

import com.spring1.aop.User;

/*
 * UserDAO负者操作数据库
 */
public interface UserDAO
{
	
	public void save(User u);
}
