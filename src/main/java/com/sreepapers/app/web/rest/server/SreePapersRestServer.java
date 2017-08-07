package com.sreepapers.app.web.rest.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class SreePapersRestServer extends SpringBootServletInitializer{

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(SreePapersRestServer.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SreePapersRestServer.class, args);
	}
	
}
