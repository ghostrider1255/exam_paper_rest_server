package com.sreepapers.app.web.rest.server.jpa.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.sreepapers.app.web.rest.server.model.ResultPattern;

public interface ResultPatternRepository extends CrudRepository<ResultPattern, Long> {
	@SuppressWarnings("unchecked")
	public ResultPattern save(ResultPattern resultPattern);
	public ResultPattern findOne(Long resultPatternId);
	public List<ResultPattern> findAll();
	public long count();
	public void delete(Long resultPatternId);
	public boolean exists(Long resultPatternId);
}
