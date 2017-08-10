package com.sreepapers.app.web.rest.server.jpa.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.sreepapers.app.web.rest.server.model.PaperPattern;

public interface PaperPatternRepository extends CrudRepository<PaperPattern, Long>{
	
	@SuppressWarnings("unchecked")
	public PaperPattern save(PaperPattern paperPattern);
	public PaperPattern findOne(Long paperPatternId);
	public List<PaperPattern> findAll();
	public long count();
	public void delete(Long paperPatternId);
	public boolean exists(Long paperPatternId);
}
