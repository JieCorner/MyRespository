package com.week15.service;

import java.util.List;

import com.week15.po.Person;

public interface PersonService {
	public void addPerson(Person person);
	public void updatePerson(Integer id);
	public void removePerson(Integer id);
	public List<Person> findAllPerson();
	public Person findById(Integer id);
}
