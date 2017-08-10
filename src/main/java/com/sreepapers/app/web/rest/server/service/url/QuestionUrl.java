package com.sreepapers.app.web.rest.server.service.url;

public class QuestionUrl {
	
	private QuestionUrl(){
	}
	
	public static final String SAVE_QUESTION = "saveQuestion";
	public static final String GET_QUESTIONS_LIST ="questions";
	public static final String DELETE_QUESTION ="deleteQuestion/{id}";
	public static final String GET_QUESTION ="question/{id}";
	public static final String UPDATE_QUESTION ="updateQuestion/{id}";

}
