package com.spring1.aop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * Bean¿‡
 */
@Entity
public class User
{
	private int id;
	private String name;
	
	@Id
	@GeneratedValue
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public User()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	
	
	
}
