package com.sreepapers.app.web.rest.server.service.url;

public class UserUrl {
	
	private UserUrl(){
	}
	
	public static final String SAVE_USER = "user/saveuser";
	public static final String GET_USERS_LIST="users";
	public static final String DELETE_USER="deleteuser/{id}";
	public static final String GET_USER="user/{id}";
	public static final String UPDATE_USER="updateuser/{id}";

}
