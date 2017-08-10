package com.sreepapers.app.web.rest.server.service.url;

public class ExamQuestionUrl {
	
	private ExamQuestionUrl(){}
	
	public static final String SAVE_EXAM_QUESTION = "addexamquestion";
	public static final String GET_EXAM_QUESTIONS="examquestions";
	public static final String DELETE_EXAM_QUESTION="deleteexamquestion/{id}";
	public static final String GET_EXAM_QUESTION="examquestion/{id}";
	public static final String UPDATE_EXAM_QUESTION="updateexamquestion/{id}";

}
