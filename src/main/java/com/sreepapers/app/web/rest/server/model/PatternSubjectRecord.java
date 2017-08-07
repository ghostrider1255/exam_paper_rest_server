package com.sreepapers.app.web.rest.server.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PATTERNSUBJECTRECORD")
public class PatternSubjectRecord implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7422214701107441903L;
	@Id
	@Column(name="pSubjectRecordId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long pSubjectRecordId;
	@OneToOne(cascade = CascadeType.ALL)
	private Subject pSubject;
	private Long numberOfQuestions;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="paperPatternId")
	private PaperPattern paperPattern;

	public Long getpSubjectRecordId() {
		return pSubjectRecordId;
	}
	public void setpSubjectRecordId(Long pSubjectRecordId) {
		this.pSubjectRecordId = pSubjectRecordId;
	}
	public Subject getpSubject() {
		return pSubject;
	}
	public void setpSubject(Subject pSubject) {
		this.pSubject = pSubject;
	}
	public Long getNumberOfQuestions() {
		return numberOfQuestions;
	}
	public void setNumberOfQuestions(Long numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}
	public PaperPattern getPaperPattern() {
		return paperPattern;
	}
	public void setPaperPattern(PaperPattern paperPattern) {
		this.paperPattern = paperPattern;
	}
}
