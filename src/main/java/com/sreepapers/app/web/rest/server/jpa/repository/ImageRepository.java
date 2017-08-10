package com.sreepapers.app.web.rest.server.jpa.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sreepapers.app.web.rest.server.model.MyImage;

@Transactional
public interface ImageRepository extends CrudRepository<MyImage, Serializable>{

	@SuppressWarnings("unchecked")
	public MyImage save(MyImage exam);
	public MyImage findOne(Long examId);
	public List<MyImage> findAll();
	public long count();
	public void delete(Long examId);
	public boolean exists(Long examId);
}
