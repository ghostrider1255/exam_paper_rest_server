package com.sreepapers.app.web.rest.server.service;

import java.util.List;

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
import org.springframework.web.util.UriComponentsBuilder;

import com.sreepapers.app.web.rest.server.jpa.repository.ExamRepository;
import com.sreepapers.app.web.rest.server.model.Exam;
import com.sreepapers.app.web.rest.server.service.url.ExamUrl;

@RestController(value="/examAction")
public class ExamController {

	@Autowired
	private ExamRepository examRepository;
	
	@GetMapping(ExamUrl.GET_EXAM)
	public ResponseEntity<Exam> getExamById(@PathVariable("id") Long id){
		Exam exam = examRepository.findOne(id);
		return new ResponseEntity<Exam>(exam,HttpStatus.OK);
	}
	
	@GetMapping(ExamUrl.GET_EXAMS)
	public ResponseEntity<List<Exam>> getAllExams(){
		List<Exam> examList = examRepository.findAll();
		return new ResponseEntity<List<Exam>>(examList, HttpStatus.OK);
	}
	
	@PostMapping(ExamUrl.SAVE_EXAM)
	public ResponseEntity<Void> saveExam(@RequestBody Exam exam, UriComponentsBuilder builder){
		Exam newExam = examRepository.save(exam);
		if(newExam == null){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path(ExamUrl.GET_EXAM).buildAndExpand(newExam.getExamId()).toUri());
		
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@PutMapping(ExamUrl.UPDATE_EXAM)
	public ResponseEntity<Exam> updateExam(@RequestBody Exam exam){
		examRepository.save(exam);
		
		return new ResponseEntity<Exam>(exam,HttpStatus.OK);
	}
	
	@DeleteMapping(ExamUrl.DELETE_EXAM)
	public ResponseEntity<Void> deleteExam(@PathVariable("id") Long id){
		examRepository.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	

}
