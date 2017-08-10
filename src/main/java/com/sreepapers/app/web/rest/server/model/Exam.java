package com.sreepapers.app.web.rest.server.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EXAM")
public class Exam implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8798477103006505006L;

	@Id
	@Column(name="examId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long examId;
	private String examCode;
	private String examDesc;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name= "paperPatternId")
	private PaperPattern paperPattern;
	@OneToMany(cascade = CascadeType.ALL,mappedBy="exam", fetch = FetchType.LAZY)
	@MapKeyColumn(name="subjectType",nullable=true)
	private Map<String,ExamQuestion> examQuestions = new HashMap<>();
	@OneToOne(cascade = CascadeType.ALL)
	private ResultPattern resultPattern;
	
	public Long getExamId() {
		return examId;
	}
	public void setEaxmId(Long examId) {
		this.examId = examId;
	}
	public String getExamCode() {
		return examCode;
	}
	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}
	public String getExamDesc() {
		return examDesc;
	}
	public void setExamDesc(String examDesc) {
		this.examDesc = examDesc;
	}
	public ResultPattern getResultPattern() {
		return resultPattern;
	}
	public void setResultPattern(ResultPattern resultPattern) {
		this.resultPattern = resultPattern;
	}
	public PaperPattern getPaperPattern() {
		return paperPattern;
	}
	public void setPaperPattern(PaperPattern paperPattern) {
		this.paperPattern = paperPattern;
	}
	public Map<String,ExamQuestion> getExamQuestions() {
		return examQuestions;
	}
	public void setExamQuestions(Map<String,ExamQuestion> examQuestions) {
		Map<String,ExamQuestion> dupExamQuestions = new HashMap<>();
		if(examQuestions!=null && examQuestions.size()>0){
			Iterator<String> iterator = examQuestions.keySet().iterator();
			while(iterator.hasNext())
			{
				String key = iterator.next();
				ExamQuestion dupObje = examQuestions.get(key);
				dupObje.setExam(this);
				dupExamQuestions.put(key, dupObje);
			}
			this.examQuestions = dupExamQuestions;
		}
		else{
			this.examQuestions = null;
		}
	}
}
