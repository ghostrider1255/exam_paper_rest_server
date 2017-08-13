package com.sreepapers.app.web.rest.server.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sreepapers.app.web.rest.server.jpa.repository.PersonRepository;
import com.sreepapers.app.web.rest.server.model.Person;
import com.sreepapers.app.web.rest.server.service.url.PersonUrl;

@RestController
@RequestMapping(value="/personAction")
public class PersonController {

	private static Logger log = LoggerFactory.getLogger(PersonController.class);
	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping(path=PersonUrl.GET_PERSON)
	public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id){
		Person person = personRepository.findOne(id);
		if(log.isDebugEnabled()){
			log.debug("returning person object with examDetails:{}",person);
		}
		else{
			log.info("returning person object with examId:{}",id);
		}
		return new ResponseEntity<>(person,HttpStatus.OK);
	}
	
	@GetMapping(path=PersonUrl.GET_PERSONS)
	public ResponseEntity<List<Person>> getAllPersons(){
		List<Person> examPersons = personRepository.findAll();
		if(log.isDebugEnabled()){
			log.debug("returning persons List of length:{}",examPersons.size());
		}
		else{
			log.info("returning persons list");
		}
		return new ResponseEntity<>(examPersons, HttpStatus.OK);
	}
	
	@PostMapping(path=PersonUrl.SAVE_PERSON)
	public ResponseEntity<Person> savePerson(@RequestBody Person persons){
		Person newPerson = personRepository.save(persons);
		if(newPerson == null){
			log.error("error saving exam object with details:{}",persons);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		if(log.isDebugEnabled()){
			log.debug("saved person object with details:{}",newPerson);
		}
		else{
			log.info("saved person object");
		}		
		return new ResponseEntity<>(newPerson,headers,HttpStatus.CREATED);
	}
	
	@PutMapping(path=PersonUrl.UPDATE_PERSON)
	public ResponseEntity<Person> updatePerson(@RequestBody Person person){
		personRepository.save(person);
		if(log.isDebugEnabled()){
			log.debug("updated person object with details:{}",person);
		}
		else{
			log.info("updated person object");
		}
		return new ResponseEntity<>(person,HttpStatus.OK);
	}
	
	@DeleteMapping(path=PersonUrl.DELETE_PERSON)
	public ResponseEntity<Void> deletePerson(@PathVariable("id") Long id){
		personRepository.delete(id);
		log.info("deleted person object:{}",id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
