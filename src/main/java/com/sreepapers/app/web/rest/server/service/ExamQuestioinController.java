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

import com.sreepapers.app.web.rest.server.jpa.repository.ExamQuestionRepository;
import com.sreepapers.app.web.rest.server.model.ExamQuestion;
import com.sreepapers.app.web.rest.server.service.url.ExamQuestionUrl;

@RestController(value="/examQuestionAction")
public class ExamQuestioinController {

	@Autowired
	private ExamQuestionRepository examQuestionRepository;

	@GetMapping(ExamQuestionUrl.GET_EXAM_QUESTION)
	public ResponseEntity<ExamQuestion> getUserById(@PathVariable("id") Long id){
		ExamQuestion examQuestion = examQuestionRepository.findOne(id);
		return new ResponseEntity<ExamQuestion>(examQuestion,HttpStatus.OK);
	}
	
	@GetMapping(ExamQuestionUrl.GET_EXAM_QUESTIONS)
	public ResponseEntity<List<ExamQuestion>> getAllExamQuestions(){
		List<ExamQuestion> examQuestionList = examQuestionRepository.findAll();
		return new ResponseEntity<List<ExamQuestion>>(examQuestionList, HttpStatus.OK);
	}
	
	@PostMapping(ExamQuestionUrl.SAVE_EXAM_QUESTION)
	public ResponseEntity<Void> saveExamQuestion(@RequestBody ExamQuestion examQuestion, UriComponentsBuilder builder){
		ExamQuestion newExamQuestion = examQuestionRepository.save(examQuestion);
		if(newExamQuestion == null){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path(ExamQuestionUrl.GET_EXAM_QUESTION).buildAndExpand(newExamQuestion.getExamQuestionId()).toUri());
		
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@PutMapping(ExamQuestionUrl.UPDATE_EXAM_QUESTION)
	public ResponseEntity<ExamQuestion> updateExamQuestion(@RequestBody ExamQuestion examQuestion){
		examQuestionRepository.save(examQuestion);
		
		return new ResponseEntity<ExamQuestion>(examQuestion,HttpStatus.OK);
	}
	
	@DeleteMapping(ExamQuestionUrl.DELETE_EXAM_QUESTION)
	public ResponseEntity<Void> deleteExamQuestion(@PathVariable("id") Long id){
		examQuestionRepository.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
