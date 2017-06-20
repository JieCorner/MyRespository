package com.spring1;

import java.sql.Connection;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;
@Component("u")
public class UserDAOImpl implements UserDAO
{
	private DataSource dataSource;
	
	public DataSource getDataSource()
	{
		return dataSource;
	}
	@Resource
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public void save(User u)
	{
		System.out.println("user saved!");
		try{
			Connection conn=dataSource.getConnection();
			conn.createStatement().executeUpdate("insert into user value('asd')");
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
