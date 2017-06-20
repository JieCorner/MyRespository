package com.hibernate.map.bean;

import java.util.HashMap;
import java.util.Map;

public class Team {
	private String id;
	private String teamname;
	private Map students=new HashMap();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	public Map getStudents() {
		return students;
	}
	public void setStudents(Map students) {
		this.students = students;
	}
	
}
