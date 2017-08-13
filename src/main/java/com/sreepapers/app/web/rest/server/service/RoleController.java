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

import com.sreepapers.app.web.rest.server.jpa.repository.RoleRepository;
import com.sreepapers.app.web.rest.server.model.Role;
import com.sreepapers.app.web.rest.server.service.url.RoleUrl;

@RestController
@RequestMapping(value="/userRoleAction")
public class RoleController {

	private static Logger log = LoggerFactory.getLogger(RoleController.class);
	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping(path=RoleUrl.GET_USER_ROLE)
	public ResponseEntity<Role> getRoleById(@PathVariable("id") Long id){
		Role role = roleRepository.findOne(id);
		if(log.isDebugEnabled()){
			log.debug("returning role object with Details:{}",role);
		}
		else{
			log.info("returning role object with Id:{}",id);
		}
		return new ResponseEntity<>(role,HttpStatus.OK);
	}
	
	@GetMapping(path=RoleUrl.GET_USER_ROLES_LIST)
	public ResponseEntity<List<Role>> getAllRoles(){
		List<Role> rolesList = roleRepository.findAll();
		if(log.isDebugEnabled()){
			log.debug("returning roles List of length:{}",rolesList.size());
		}
		else{
			log.info("returning roles list");
		}
		return new ResponseEntity<>(rolesList, HttpStatus.OK);
	}
	
	@PostMapping(path=RoleUrl.SAVE_USER_ROLE)
	public ResponseEntity<Role> saveRole(@RequestBody Role role){
		Role newRole = roleRepository.save(role);
		if(newRole == null){
			log.error("error saving role object with details:{}",role);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		if(log.isDebugEnabled()){
			log.debug("saved role object with details:{}",newRole);
		}
		else{
			log.info("saved role object");
		}		
		return new ResponseEntity<>(newRole,headers,HttpStatus.CREATED);
	}
	
	@PutMapping(path=RoleUrl.UPDATE_USER_ROLE)
	public ResponseEntity<Role> updateRole(@RequestBody Role role){
		roleRepository.save(role);
		if(log.isDebugEnabled()){
			log.debug("updated role object with details:{}",role);
		}
		else{
			log.info("updated role object");
		}
		return new ResponseEntity<>(role,HttpStatus.OK);
	}
	
	@DeleteMapping(path=RoleUrl.DELETE_USER_ROLE)
	public ResponseEntity<Void> deleteRole(@PathVariable("id") Long id){
		roleRepository.delete(id);
		log.info("deleted role object:{}",id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
