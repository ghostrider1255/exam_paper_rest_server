package com.sreepapers.app.web.rest.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SUBJECT")
public class Subject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3494141867172865683L;
	@Id
	@Column(name="subjectId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long subjectId;
	private String subjectCode;
	private String subjectDesc;
	private boolean subjectStatus;
	
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getSubjectDesc() {
		return subjectDesc;
	}
	public void setSubjectDesc(String subjectDesc) {
		this.subjectDesc = subjectDesc;
	}
	public boolean isSubjectStatus() {
		return subjectStatus;
	}
	public void setSubjectStatus(boolean subjectStatus) {
		this.subjectStatus = subjectStatus;
	}
	
	@Override
	public String toString(){
		return "Subject[subjectCode="+this.subjectCode+", subjectDesc="+this.subjectDesc+", subjectStatus="+this.subjectStatus+"]";
	}
}
