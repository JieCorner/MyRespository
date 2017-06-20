package com.week15.daoImpl;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.week15.dao.PersonDao;
import com.week15.po.Person;

public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao{

	@Override
	public List<Person> getPersons() {
		// TODO Auto-generated method stub
		List<Person> persons=(List<Person>)getHibernateTemplate().find("from Person");
		return persons;
	}

	@Override
	public Person getPerson(Integer pid) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Person.class, pid);
	}

	@Override
	public void saveOrUpdatePerson(Person person) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(person);
	}

	@Override
	public void removePerson(Person person) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(person);
	}

}
