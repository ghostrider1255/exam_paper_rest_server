package com.sreepapers.app.web.rest.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
public class ConfigurationRestServer {

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
