package com.sreepapers.app.web.rest.server.jpa.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.sreepapers.app.web.rest.server.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	@SuppressWarnings("unchecked")
	public User save(User user);
	public User findOne(Long userId);
	public List<User> findAll();
	public long count();
	public void delete(Long userId);
	public boolean exists(Long userId);
	//public User update(User user);
}
