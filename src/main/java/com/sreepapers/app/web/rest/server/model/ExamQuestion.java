package com.sreepapers.app.web.rest.server.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EXAMQUESTION")
public class ExamQuestion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9184196183355060125L;
	@Id
	@Column(name="examQuestionId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long examQuestionId;
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY )
	@JoinTable(name="ExamQuestionMap" , joinColumns = { @JoinColumn(name="examQuestionId")}, inverseJoinColumns = { @JoinColumn(name="questionId")})
	private List<Question> questions;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="examId")
	private Exam exam;

	public Long getExamQuestionId() {
		return examQuestionId;
	}
	public void setExamQuestionId(Long examQuestionId) {
		this.examQuestionId = examQuestionId;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
}
