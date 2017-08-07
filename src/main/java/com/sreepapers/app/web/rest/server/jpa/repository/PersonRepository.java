package com.sreepapers.app.web.rest.server.jpa.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.sreepapers.app.web.rest.server.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{

	@SuppressWarnings("unchecked")
	public Person save(Person person);
	public Person findOne(Long personId);
	public List<Person> findAll();
	public long count();
	public void delete(Long personId);
	public boolean exists(Long personId);
	//public Person update(Person person);
}
