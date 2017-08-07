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

import com.sreepapers.app.web.rest.server.jpa.repository.UserRepository;
import com.sreepapers.app.web.rest.server.model.User;
import com.sreepapers.app.web.rest.server.service.url.UrlUser;

@RestController(value="/userAction")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(UrlUser.GET_USER)
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
		User user = userRepository.findOne(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping(UrlUser.GET_USERS_LIST)
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> usersList = userRepository.findAll();
		return new ResponseEntity<List<User>>(usersList, HttpStatus.OK);
	}
	
	@PostMapping(UrlUser.SAVE_USER)
	public ResponseEntity<Void> saveUser(@RequestBody User user, UriComponentsBuilder builder){
		User newUser = userRepository.save(user);
		if(newUser == null){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path(UrlUser.GET_USER).buildAndExpand(user.getUserId()).toUri());
		
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@PutMapping(UrlUser.UPDATE_USER)
	public ResponseEntity<User> updateUser(@RequestBody User user){
		userRepository.save(user);
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@DeleteMapping(UrlUser.DELETE_USER)
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id){
		userRepository.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
