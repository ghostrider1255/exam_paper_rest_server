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

import com.sreepapers.app.web.rest.server.jpa.repository.PatternSubjectRecordRepository;
import com.sreepapers.app.web.rest.server.model.PatternSubjectRecord;
import com.sreepapers.app.web.rest.server.service.url.PatternSubjectRecUrl;

@RestController(value="/examAction")
//@RestController
public class PatternSubjectRecController {

	private static Logger log = LoggerFactory.getLogger(PatternSubjectRecController.class);
	@Autowired
	private PatternSubjectRecordRepository patternSubjectRecRepository;
	
	@GetMapping(path=PatternSubjectRecUrl.GET_PATTERN_SUBJECT_REOCRD)
	public ResponseEntity<PatternSubjectRecord> getPatternSubjectRecordById(@PathVariable("id") Long id){
		PatternSubjectRecord patternSubjectRecord = patternSubjectRecRepository.findOne(id);
		if(log.isDebugEnabled()){
			log.debug("returning patternSubjectRecord object with examDetails:{}",patternSubjectRecord);
		}
		else{
			log.info("returning patternSubjectRecord object with examId:{}",id);
		}
		return new ResponseEntity<>(patternSubjectRecord,HttpStatus.OK);
	}
	
	@GetMapping(path=PatternSubjectRecUrl.GET_PATTERN_SUBJECT_REOCRD_LIST)
	public ResponseEntity<List<PatternSubjectRecord>> getAllPatternSubjectRecords(){
		List<PatternSubjectRecord> patternSubjectRecordList = patternSubjectRecRepository.findAll();
		if(log.isDebugEnabled()){
			log.debug("returning patternSubjectRecords List of length:{}",patternSubjectRecordList.size());
		}
		else{
			log.info("returning patternSubjectRecords list");
		}
		return new ResponseEntity<>(patternSubjectRecordList, HttpStatus.OK);
	}
	
	@PostMapping(path=PatternSubjectRecUrl.SAVE_PATTERN_SUBJECT_REOCRD)
	public ResponseEntity<PatternSubjectRecord> savePatternSubjectRecord(@RequestBody PatternSubjectRecord patternSubjectRecord){
		PatternSubjectRecord newPatternSubjectRecord = patternSubjectRecRepository.save(patternSubjectRecord);
		if(newPatternSubjectRecord == null){
			log.error("error saving patternSubjectRecord object with details:{}",patternSubjectRecord);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		if(log.isDebugEnabled()){
			log.debug("saved patternSubjectRecord object with details:{}",newPatternSubjectRecord);
		}
		else{
			log.info("saved patternSubjectRecord object");
		}		
		return new ResponseEntity<>(newPatternSubjectRecord,headers,HttpStatus.CREATED);
	}
	
	@PutMapping(path=PatternSubjectRecUrl.UPDATE_PATTERN_SUBJECT_REOCRD)
	public ResponseEntity<PatternSubjectRecord> updatePatternSubjectRecord(@RequestBody PatternSubjectRecord patternSubjectRecord){
		patternSubjectRecRepository.save(patternSubjectRecord);
		if(log.isDebugEnabled()){
			log.debug("updated patternSubjectRecord object with details:{}",patternSubjectRecord);
		}
		else{
			log.info("updated patternSubjectRecord object");
		}
		return new ResponseEntity<>(patternSubjectRecord,HttpStatus.OK);
	}
	
	@DeleteMapping(path=PatternSubjectRecUrl.DELETE_PATTERN_SUBJECT_REOCRD)
	public ResponseEntity<Void> deletePatternSubjectRecord(@PathVariable("id") Long id){
		patternSubjectRecRepository.delete(id);
		log.info("deleted patternSubjectRecord object:{}",id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
