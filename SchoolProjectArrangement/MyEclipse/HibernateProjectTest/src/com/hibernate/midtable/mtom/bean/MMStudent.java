package com.hibernate.midtable.mtom.bean;

import java.util.Set;

public class MMStudent {
	private String id;
	private String name;
	private Set<MMCourse> courses;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<MMCourse> getCourses() {
		return courses;
	}
	public void setCourses(Set<MMCourse> courses) {
		this.courses = courses;
	}
	
}
