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

import com.sreepapers.app.web.rest.server.jpa.repository.PaperPatternRepository;
import com.sreepapers.app.web.rest.server.model.PaperPattern;
import com.sreepapers.app.web.rest.server.service.url.PaperPatternUrl;

@RestController
@RequestMapping(value="/patternAction")
public class PaperPatternController {

	private static Logger log = LoggerFactory.getLogger(PaperPatternController.class);
	
	@Autowired
	private PaperPatternRepository paperPatternRepository;
	
	@GetMapping(path=PaperPatternUrl.GET_PAPER_PATTERN)
	public ResponseEntity<PaperPattern> getPaperPatternById(@PathVariable("id") Long id){
		PaperPattern paperPattern = paperPatternRepository.findOne(id);
		if(log.isDebugEnabled()){
			log.debug("returning paperPattern object with examDetails:{}",paperPattern);
		}
		else{
			log.info("returning paperPattern object with examId:{}",id);
		}
		return new ResponseEntity<>(paperPattern,HttpStatus.OK);
	}
	
	@GetMapping(path=PaperPatternUrl.GET_PAPER_PATTERNS)
	public ResponseEntity<List<PaperPattern>> getAllPaperPatterns(){
		List<PaperPattern> paperPatternList = paperPatternRepository.findAll();
		if(log.isDebugEnabled()){
			log.debug("returning paperPattern List of length:{}",paperPatternList.size());
		}
		else{
			log.info("returning paperPattern list");
		}
		return new ResponseEntity<>(paperPatternList, HttpStatus.OK);
	}
	
	@PostMapping(path=PaperPatternUrl.SAVE_PAPER_PATTERN)
	public ResponseEntity<PaperPattern> savePaperPattern(@RequestBody PaperPattern paperPattern){
		PaperPattern newpaperPattern = paperPatternRepository.save(paperPattern);
		if(newpaperPattern == null){
			log.error("error saving paperPattern object with details:{}",paperPattern);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		if(log.isDebugEnabled()){
			log.debug("saved paperPattern object with details:{}",paperPattern);
		}
		else{
			log.info("saved paperPattern object");
		}		
		return new ResponseEntity<>(newpaperPattern,headers,HttpStatus.CREATED);
	}
	
	@PutMapping(path=PaperPatternUrl.UPDATE_PAPER_PATTERN)
	public ResponseEntity<PaperPattern> updatePaperPattern(@RequestBody PaperPattern paperPattern){
		paperPatternRepository.save(paperPattern);
		if(log.isDebugEnabled()){
			log.debug("updated paperPattern object with details:{}",paperPattern);
		}
		else{
			log.info("updated paperPattern object");
		}
		return new ResponseEntity<>(paperPattern,HttpStatus.OK);
	}
	
	@DeleteMapping(path=PaperPatternUrl.DELETE_PAPER_PATTERN)
	public ResponseEntity<Void> deletePaperPattern(@PathVariable("id") Long id){
		paperPatternRepository.delete(id);
		log.info("deleted paperPattern object:{}",id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
