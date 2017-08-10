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

import com.sreepapers.app.web.rest.server.jpa.repository.ExamRepository;
import com.sreepapers.app.web.rest.server.model.Exam;
import com.sreepapers.app.web.rest.server.service.url.ExamUrl;

@RestController(value="/examAction")
//@RestController
public class ExamController {

	private static Logger log = LoggerFactory.getLogger(ExamController.class);
	@Autowired
	private ExamRepository examRepository;
	
	@GetMapping(path=ExamUrl.GET_EXAM)
	public ResponseEntity<Exam> getExamById(@PathVariable("id") Long id){
		Exam exam = examRepository.findOne(id);
		if(log.isDebugEnabled()){
			log.debug("returning exam object with examDetails:{}",exam);
		}
		else{
			log.info("returning exam object with examId:{}",id);
		}
		return new ResponseEntity<>(exam,HttpStatus.OK);
	}
	
	@GetMapping(path=ExamUrl.GET_EXAMS)
	public ResponseEntity<List<Exam>> getAllExams(){
		List<Exam> examList = examRepository.findAll();
		if(log.isDebugEnabled()){
			log.debug("returning exams List of length:{}",examList.size());
		}
		else{
			log.info("returning exams list");
		}
		return new ResponseEntity<>(examList, HttpStatus.OK);
	}
	
	@PostMapping(path=ExamUrl.SAVE_EXAM)
	public ResponseEntity<Exam> saveExam(@RequestBody Exam exam){
		Exam newExam = examRepository.save(exam);
		if(newExam == null){
			log.error("error saving exam object with details:{}",exam);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		if(log.isDebugEnabled()){
			log.debug("saved exam object with details:{}",newExam);
		}
		else{
			log.info("saved exam object");
		}		
		return new ResponseEntity<>(newExam,headers,HttpStatus.CREATED);
	}
	
	@PutMapping(path=ExamUrl.UPDATE_EXAM)
	public ResponseEntity<Exam> updateExam(@RequestBody Exam exam){
		examRepository.save(exam);
		if(log.isDebugEnabled()){
			log.debug("updated exam object with details:{}",exam);
		}
		else{
			log.info("updated exam object");
		}
		return new ResponseEntity<>(exam,HttpStatus.OK);
	}
	
	@DeleteMapping(path=ExamUrl.DELETE_EXAM)
	public ResponseEntity<Void> deleteExam(@PathVariable("id") Long id){
		examRepository.delete(id);
		log.info("deleted exam object:{}",id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
