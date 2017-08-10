package com.sreepapers.app.web.rest.server.service.url;

public class ResultPatternUrl {
	
	private ResultPatternUrl(){
	}
	
	public static final String SAVE_RESULT_PATTERN = "resultPattern";
	public static final String GET_RESULT_PATTERN_LIST ="resultPatterns";
	public static final String DELETE_RESULT_PATTER ="deleteResultPattern/{id}";
	public static final String GET_RESULT_PATTERN ="resultPattern/{id}";
	public static final String UPDATE_RESULT_PATTERN ="updateResultPattern/{id}";
}
