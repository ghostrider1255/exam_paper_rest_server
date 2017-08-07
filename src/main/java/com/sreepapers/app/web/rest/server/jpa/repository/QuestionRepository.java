package com.sreepapers.app.web.rest.server.jpa.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.sreepapers.app.web.rest.server.model.Question;

public interface QuestionRepository extends CrudRepository<Question, Long>{
	
	@SuppressWarnings("unchecked")
	public Question save(Question question);
	public Question findOne(Long questionId);
	public List<Question> findAll();
	public long count();
	public void delete(Long questionid);
	public boolean exists(Long questionId);
	//public Question update(Question question);
}
