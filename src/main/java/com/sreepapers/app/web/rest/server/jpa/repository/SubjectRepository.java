package com.sreepapers.app.web.rest.server.jpa.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.sreepapers.app.web.rest.server.model.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Long>{
	@SuppressWarnings("unchecked")
	public Subject save(Subject subject);
	public Subject findOne(Long subjectId);
	public List<Subject> findAll();
	public long count();
	public void delete(Long subjectId);
	public boolean exists(Long subjectId);
}
