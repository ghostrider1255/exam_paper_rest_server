package com.sreepapers.app.web.rest.server.jpa.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.sreepapers.app.web.rest.server.model.ExamQuestion;

@Service
public interface ExamQuestionRepository extends CrudRepository<ExamQuestion, Long>{
	
	@SuppressWarnings("unchecked")
	public com.sreepapers.app.web.rest.server.model.ExamQuestion save(ExamQuestion examQuestion);
	public ExamQuestion findOne(Long examQuestionId);
	public List<ExamQuestion> findAll();
	public long count();
	public void delete(ExamQuestion examQuestion);
	public boolean exists(Long examQuestionId);

}
