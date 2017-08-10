package com.sreepapers.app.web.rest.server.jpa.repository;


import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.sreepapers.app.web.rest.server.model.Exam;

public interface ExamRepository extends CrudRepository<Exam, Long>{

	@SuppressWarnings("unchecked")
	public Exam save(Exam exam);
	public Exam findOne(Long examId);
	public List<Exam> findAll();
	public long count();
	public void delete(Long examId);
	public boolean exists(Long examId);
}
