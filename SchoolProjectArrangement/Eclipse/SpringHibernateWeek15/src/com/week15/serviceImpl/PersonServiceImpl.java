package com.week15.serviceImpl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import com.week15.dao.PersonDao;
import com.week15.po.Person;
import com.week15.service.PersonService;
@Transactional(readOnly=false)
public class PersonServiceImpl implements PersonService {

	@Resource private PersonDao personDao;
	
	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		personDao.saveOrUpdatePerson(person);
	}

	@Override
	public void updatePerson(Integer id) {
		// TODO Auto-generated method stub
		Person person=findById(id);
		person.setName("AAA");
		personDao.saveOrUpdatePerson(person);
	}

	@Override
	public void removePerson(Integer id) {
		// TODO Auto-generated method stub
		Person person=findById(id);
		personDao.removePerson(person);
	}

	@Override
	public List<Person> findAllPerson() {
		// TODO Auto-generated method stub
		return personDao.getPersons();
	}

	@Override
	public Person findById(Integer id) {
		// TODO Auto-generated method stub
		return personDao.getPerson(id);
	}

}
