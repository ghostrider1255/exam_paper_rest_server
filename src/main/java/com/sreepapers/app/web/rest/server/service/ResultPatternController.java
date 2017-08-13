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

import com.sreepapers.app.web.rest.server.jpa.repository.ResultPatternRepository;
import com.sreepapers.app.web.rest.server.model.ResultPattern;
import com.sreepapers.app.web.rest.server.service.url.ResultPatternUrl;

@RestController
@RequestMapping(value="/resultPatternAction")
public class ResultPatternController {

	private static Logger log = LoggerFactory.getLogger(ResultPatternController.class);
	@Autowired
	private ResultPatternRepository resultPatternRepository;
	
	@GetMapping(path=ResultPatternUrl.GET_RESULT_PATTERN)
	public ResponseEntity<ResultPattern> getResultPatternById(@PathVariable("id") Long id){
		ResultPattern resultPattern = resultPatternRepository.findOne(id);
		if(log.isDebugEnabled()){
			log.debug("returning resultPattern object with Details:{}",resultPattern);
		}
		else{
			log.info("returning resultPattern object with Id:{}",id);
		}
		return new ResponseEntity<>(resultPattern,HttpStatus.OK);
	}
	
	@GetMapping(path=ResultPatternUrl.GET_RESULT_PATTERN_LIST)
	public ResponseEntity<List<ResultPattern>> getAllResultPatterns(){
		List<ResultPattern> resultPatternList = resultPatternRepository.findAll();
		if(log.isDebugEnabled()){
			log.debug("returning resultPatterns List of length:{}",resultPatternList.size());
		}
		else{
			log.info("returning resultPatterns list");
		}
		return new ResponseEntity<>(resultPatternList, HttpStatus.OK);
	}
	
	@PostMapping(path=ResultPatternUrl.SAVE_RESULT_PATTERN)
	public ResponseEntity<ResultPattern> saveResultPattern(@RequestBody ResultPattern resultPattern){
		ResultPattern newResultPattern = resultPatternRepository.save(resultPattern);
		if(newResultPattern == null){
			log.error("error saving resultPattern object with details:{}",resultPattern);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		if(log.isDebugEnabled()){
			log.debug("saved resultPattern object with details:{}",newResultPattern);
		}
		else{
			log.info("saved resultPattern object");
		}		
		return new ResponseEntity<>(newResultPattern,headers,HttpStatus.CREATED);
	}
	
	@PutMapping(path=ResultPatternUrl.UPDATE_RESULT_PATTERN)
	public ResponseEntity<ResultPattern> updateResultPattern(@RequestBody ResultPattern resultPattern){
		resultPatternRepository.save(resultPattern);
		if(log.isDebugEnabled()){
			log.debug("updated resultPattern object with details:{}",resultPattern);
		}
		else{
			log.info("updated resultPattern object");
		}
		return new ResponseEntity<>(resultPattern,HttpStatus.OK);
	}
	
	@DeleteMapping(path=ResultPatternUrl.DELETE_RESULT_PATTER)
	public ResponseEntity<Void> deleteResultPattern(@PathVariable("id") Long id){
		resultPatternRepository.delete(id);
		log.info("deleted resultPattern object:{}",id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
