package com.hibernate.midtable.mtom.bean;

import java.util.Set;

public class MMCourse {
	private String id;
	private String name;
	private Set<MMStudent> students;
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
	public Set<MMStudent> getStudents() {
		return students;
	}
	public void setStudents(Set<MMStudent> students) {
		this.students = students;
	}
}
