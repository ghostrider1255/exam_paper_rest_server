package com.sreepapers.app.web.rest.server;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class ConfigurationRestServer extends WebMvcConfigurerAdapter{

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
