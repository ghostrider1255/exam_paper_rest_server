package com.sreepapers.app.web.rest.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RESULTPATTERN")
public class ResultPattern implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6434547282898295758L;
	@Id
	@Column(name="resultPatternId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long resultPatternId;
	private float marksPerAnswer;
	private float negativePerWrong;
	private float passPercentage;
	
	public Long getResultPatternId() {
		return resultPatternId;
	}
	public void setResultPatternId(Long resultPatternId) {
		this.resultPatternId = resultPatternId;
	}
	public float getPassPercentage() {
		return passPercentage;
	}
	public void setPassPercentage(float passPercentage) {
		this.passPercentage = passPercentage;
	}
	public float getMarksPerAnswer() {
		return marksPerAnswer;
	}
	public void setMarksPerAnswer(float marksPerAnswer) {
		this.marksPerAnswer = marksPerAnswer;
	}
	public float getNegativePerWrong() {
		return negativePerWrong;
	}
	public void setNegativePerWrong(float negativePerWrong) {
		this.negativePerWrong = negativePerWrong;
	}
}
