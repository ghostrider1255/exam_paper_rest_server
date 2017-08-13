package com.sreepapers.app.web.rest.server.jpa.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.sreepapers.app.web.rest.server.model.MyImage;

public interface ImageRepository extends CrudRepository<MyImage, Long>{

	@SuppressWarnings("unchecked")
	public MyImage save(MyImage image);
	public MyImage findOne(Long imageId);
	public List<MyImage> findAll();
	public long count();
	public void delete(Long imageId);
	public boolean exists(Long imageId);
}
