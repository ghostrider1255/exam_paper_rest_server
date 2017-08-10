package com.sreepapers.app.web.rest.server.jpa.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.sreepapers.app.web.rest.server.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
	@SuppressWarnings("unchecked")
	public Role save(Role role);
	public Role findOne(Long roleId);
	public List<Role> findAll();
	public long count();
	public void delete(Long roleId);
	public boolean exists(Long roleId);
}
