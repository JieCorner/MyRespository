package com.week15.dao;

import java.util.List;

import com.week15.po.Person;

public interface PersonDao {
	public List<Person> getPersons();
	public Person getPerson(Integer pid);
	public void saveOrUpdatePerson(Person person);
	public void removePerson(Person person);
}
