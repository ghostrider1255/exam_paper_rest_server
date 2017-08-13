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

import com.sreepapers.app.web.rest.server.jpa.repository.QuestionRepository;
import com.sreepapers.app.web.rest.server.model.Question;
import com.sreepapers.app.web.rest.server.service.url.QuestionUrl;

@RestController
@RequestMapping(value="/questionAction")
public class QuestionController {

	private static Logger log = LoggerFactory.getLogger(QuestionController.class);
	@Autowired
	private QuestionRepository questionRepository;
	
	@GetMapping(path=QuestionUrl.GET_QUESTION)
	public ResponseEntity<Question> getQuestionById(@PathVariable("id") Long id){
		Question question = questionRepository.findOne(id);
		if(log.isDebugEnabled()){
			log.debug("returning question object with Details:{}",question);
		}
		else{
			log.info("returning question object with Id:{}",id);
		}
		return new ResponseEntity<>(question,HttpStatus.OK);
	}
	
	@GetMapping(path=QuestionUrl.GET_QUESTIONS_LIST)
	public ResponseEntity<List<Question>> getAllQuestions(){
		List<Question> questionsList = questionRepository.findAll();
		if(log.isDebugEnabled()){
			log.debug("returning questions List of length:{}",questionsList.size());
		}
		else{
			log.info("returning questions list");
		}
		return new ResponseEntity<>(questionsList, HttpStatus.OK);
	}
	
	@GetMapping(path=QuestionUrl.GET_QUESTIONS_BY_SUBJECT)
	public ResponseEntity<List<Object>> getQuestionsBySubject(@PathVariable("subjectId") Long subjectId){
		List<Object> questionsList = questionRepository.findBySubjectsId(subjectId);
		if(log.isDebugEnabled()){
			log.debug("returning questions List of length:{}",questionsList.size());
		}
		else{
			log.info("returning questions list");
		}
		return new ResponseEntity<>(questionsList, HttpStatus.OK);
	}
	
	@PostMapping(path=QuestionUrl.SAVE_QUESTION)
	public ResponseEntity<Question> saveQuestion(@RequestBody Question question){
		Question newQuestion = questionRepository.save(question);
		if(newQuestion == null){
			log.error("error saving question object with details:{}",question);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		if(log.isDebugEnabled()){
			log.debug("saved question object with details:{}",newQuestion);
		}
		else{
			log.info("saved question object");
		}		
		return new ResponseEntity<>(newQuestion,headers,HttpStatus.CREATED);
	}
	
	@PutMapping(path=QuestionUrl.UPDATE_QUESTION)
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
		questionRepository.save(question);
		if(log.isDebugEnabled()){
			log.debug("updated question object with details:{}",question);
		}
		else{
			log.info("updated question object");
		}
		return new ResponseEntity<>(question,HttpStatus.OK);
	}
	
	@DeleteMapping(path=QuestionUrl.DELETE_QUESTION)
	public ResponseEntity<Void> deleteQuestion(@PathVariable("id") Long id){
		questionRepository.delete(id);
		log.info("deleted question object:{}",id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
