package com.sreepapers.app.web.rest.server.service.url;

public class PersonUrl {
	
	private PersonUrl(){}
	
	public static final String SAVE_PERSON = "savePerson";
	public static final String GET_PERSONS ="persons";
	public static final String DELETE_PERSON ="deletePerson/{id}";
	public static final String GET_PERSON ="person/{id}";
	public static final String UPDATE_PERSON ="updatePerson";
}
