package com.sreepapers.app.web.rest.server.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="QUESTION")
public class Question implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6649881076488319134L;
	@Id
	@Column(name="questionId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long questionId;
	@Column(length=1000)
	private String questionText;
	private String choiceOne;
	private String choiceTwo;
	private String choiceThree;
	private String choiceFour;
	private String choiceFive;
	private String answer;
	private String explanation;
	private boolean status;
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinTable(name = "QSUBJECTTAG", joinColumns = { @JoinColumn (name = "questionId")}, inverseJoinColumns = { @JoinColumn(name = "subjectId")})
	private Set<Subject> subjects = new HashSet<Subject>();
	@ManyToOne
	private ExamQuestion examQuestion;
	
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public String getChoiceOne() {
		return choiceOne;
	}
	public void setChoiceOne(String choiceOne) {
		this.choiceOne = choiceOne;
	}
	public String getChoiceTwo() {
		return choiceTwo;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public void setChoiceTwo(String choiceTwo) {
		this.choiceTwo = choiceTwo;
	}
	public String getChoiceThree() {
		return choiceThree;
	}
	public void setChoiceThree(String choiceThree) {
		this.choiceThree = choiceThree;
	}
	public String getChoiceFour() {
		return choiceFour;
	}
	public void setChoiceFour(String choiceFour) {
		this.choiceFour = choiceFour;
	}
	public String getChoiceFive() {
		return choiceFive;
	}
	public void setChoiceFive(String choiceFive) {
		this.choiceFive = choiceFive;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Set<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
}
