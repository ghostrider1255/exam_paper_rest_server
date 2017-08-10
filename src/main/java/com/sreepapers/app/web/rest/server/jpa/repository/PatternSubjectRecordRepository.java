package com.sreepapers.app.web.rest.server.jpa.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.sreepapers.app.web.rest.server.model.PatternSubjectRecord;


public interface PatternSubjectRecordRepository extends CrudRepository<PatternSubjectRecord, Long>{

	@SuppressWarnings("unchecked")
	public PatternSubjectRecord save(PatternSubjectRecord patternSubjectRecord);
	public PatternSubjectRecord findOne(Long patternSubjectRecordId);
	public List<PatternSubjectRecord> findAll();
	public long count();
	public void delete(Long patternSubjectRecordId);
	public boolean exists(Long patternSubRecordId);
}
