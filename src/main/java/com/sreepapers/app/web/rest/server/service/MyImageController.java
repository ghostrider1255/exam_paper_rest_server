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

import com.sreepapers.app.web.rest.server.jpa.repository.ImageRepository;
import com.sreepapers.app.web.rest.server.model.MyImage;
import com.sreepapers.app.web.rest.server.service.url.MyImageUrl;

@RestController
@RequestMapping(value="/imageAction")
public class MyImageController {

	private static Logger log = LoggerFactory.getLogger(MyImageController.class);

	@Autowired
	private ImageRepository imageRepository;
	
	@GetMapping(path=MyImageUrl.GET_IMAGE)
	public ResponseEntity<MyImage> getExamById(@PathVariable("id") Long id){
		MyImage image = imageRepository.findOne(id);
		if(log.isDebugEnabled()){
			log.debug("returning image object with Details:{}",image);
		}
		else{
			log.info("returning image object with imageId:{}",id);
		}
		return new ResponseEntity<>(image,HttpStatus.OK);
	}
	
	@GetMapping(path=MyImageUrl.GET_IMAGES)
	public ResponseEntity<List<MyImage>> getAllExams(){
		List<MyImage> imageList = imageRepository.findAll();
		if(log.isDebugEnabled()){
			log.debug("returning images List of length:{}",imageList.size());
		}
		else{
			log.info("returning images list");
		}
		return new ResponseEntity<>(imageList, HttpStatus.OK);
	}
	
	@PostMapping(path=MyImageUrl.SAVE_IMAGE)
	public ResponseEntity<MyImage> saveExam(@RequestBody MyImage image){
		MyImage newImage = imageRepository.save(image);
		if(newImage == null){
			log.error("error saving image object with details:{}",image);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		if(log.isDebugEnabled()){
			log.debug("saved image object with details:{}",newImage);
		}
		else{
			log.info("saved image object");
		}		
		return new ResponseEntity<>(newImage,headers,HttpStatus.CREATED);
	}
	
	@PutMapping(path=MyImageUrl.UPDATE_IMAGE)
	public ResponseEntity<MyImage> updateExam(@RequestBody MyImage image){
		imageRepository.save(image);
		if(log.isDebugEnabled()){
			log.debug("updated image object with details:{}",image);
		}
		else{
			log.info("updated exam object");
		}
		return new ResponseEntity<>(image,HttpStatus.OK);
	}
	
	@DeleteMapping(path=MyImageUrl.DELETE_IMAGE)
	public ResponseEntity<Void> deleteExam(@PathVariable("id") Long id){
		imageRepository.delete(id);
		log.info("deleted image object:{}",id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
