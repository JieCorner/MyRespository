package com.news.management.bean;

import java.util.HashSet;
import java.util.Set;

public class User {
	private Integer id;
	private String username;
	private String password;
	private boolean manager;
	private String email;
	private int age;
	private Set<Comment> usercomments;
	
	public Set<Comment> getUsercomments() {
		return usercomments;
	}
	public void setUsercomments(Set<Comment> usercomments) {
		this.usercomments = usercomments;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getManager() {
		return manager;
	}
	public void setManager(boolean manager) {
		this.manager = manager;
	}
	
	
}
