package com.sreepapers.app.web.rest.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class SreePapersRestServer extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(SreePapersRestServer.class);
	}
	public static void main(String[] args) {
		new SpringApplicationBuilder(SreePapersRestServer.class)
		//.bannerMode(Mode.OFF)
		.build().run(args);
	}
	
}
