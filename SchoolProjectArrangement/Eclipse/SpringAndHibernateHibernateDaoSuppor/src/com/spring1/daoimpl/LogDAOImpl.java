package com.spring1.daoimpl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.spring1.aop.Log;
import com.spring1.dao.SuperDAO;
import com.spring1.dao.LogDAO;

@Component("log")
public class LogDAOImpl extends SuperDAO implements LogDAO
{
	@Override
	public void savelog(Log log)
	{
		this.getHibernateTemplate().save(log);
	}
}
