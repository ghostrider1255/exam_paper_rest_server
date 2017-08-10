package com.sreepapers.app.web.rest.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="imageTest")
public class MyImage implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8906489443677120849L;
	@Id
	@Column(name="imageId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long imageId;
	private String imageTitle;
	private byte[] imageData;
	
	public Long getImageId() {
		return imageId;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	public String getImageTitle() {
		return imageTitle;
	}
	public void setImageTitle(String imageTitle) {
		this.imageTitle = imageTitle;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	
	@Override
	public String toString(){
		return "MyImage[imageTitile="+this.imageTitle+"]";
	}
}
