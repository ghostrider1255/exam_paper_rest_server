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
import org.springframework.web.bind.annotation.RestController;

import com.sreepapers.app.web.rest.server.jpa.repository.SubjectRepository;
import com.sreepapers.app.web.rest.server.model.Subject;
import com.sreepapers.app.web.rest.server.service.url.SubjectUrl;

@RestController(value="/subjectAction")
public class SubjectController {

	private static Logger log = LoggerFactory.getLogger(SubjectController.class);
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@GetMapping(path=SubjectUrl.GET_SUBJECT)
	public ResponseEntity<Subject> getSubjectById(@PathVariable("id") Long id){
		Subject subject = subjectRepository.findOne(id);
		if(log.isDebugEnabled()){
			log.debug("returning subject object with Details:{}",subject);
		}
		else{
			log.info("returning subject object with Id:{}",id);
		}
		return new ResponseEntity<>(subject,HttpStatus.OK);
	}
	
	@GetMapping(path=SubjectUrl.GET_SUBJECTS)
	public ResponseEntity<List<Subject>> getAllSubjects(){
		List<Subject> subjectsList = subjectRepository.findAll();
		if(log.isDebugEnabled()){
			log.debug("returning subjects List of length:{}",subjectsList.size());
		}
		else{
			log.info("returning subjects list");
		}
		return new ResponseEntity<>(subjectsList, HttpStatus.OK);
	}
	
	@PostMapping(path=SubjectUrl.SAVE_SUBJECT)
	public ResponseEntity<Subject> saveSubject(@RequestBody Subject subject){
		Subject newSubject = subjectRepository.save(subject);
		if(newSubject == null){
			log.error("error saving subject object with details:{}",subject);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		if(log.isDebugEnabled()){
			log.debug("saved subject object with details:{}",newSubject);
		}
		else{
			log.info("saved subject object");
		}		
		return new ResponseEntity<>(newSubject,headers,HttpStatus.CREATED);
	}
	
	@PutMapping(path=SubjectUrl.UPDATE_SUBJECT)
	public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject){
		subjectRepository.save(subject);
		if(log.isDebugEnabled()){
			log.debug("updated subject object with details:{}",subject);
		}
		else{
			log.info("updated subject object");
		}
		return new ResponseEntity<>(subject,HttpStatus.OK);
	}
	
	@DeleteMapping(path=SubjectUrl.DELETE_SUBJECT)
	public ResponseEntity<Void> deleteSubject(@PathVariable("id") Long id){
		subjectRepository.delete(id);
		log.info("deleted subject object:{}",id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
