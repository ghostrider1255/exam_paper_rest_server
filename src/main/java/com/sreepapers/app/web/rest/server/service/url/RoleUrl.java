package com.sreepapers.app.web.rest.server.service.url;

public class RoleUrl {
	
	private RoleUrl(){
	}
	
	public static final String SAVE_USER_ROLE = "userRole";
	public static final String GET_USER_ROLES_LIST ="userRoles";
	public static final String DELETE_USER_ROLE ="deleteUserRole/{id}";
	public static final String GET_USER_ROLE ="userRole/{id}";
	public static final String UPDATE_USER_ROLE ="updateUserRole/{id}";

}
