package com.sreepapers.app.web.rest.server.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.sreepapers.app.web.rest.server.ConfigurationRestServer;
import com.sreepapers.app.web.rest.server.model.Exam;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= {ConfigurationRestServer.class})
public class ExamRestServiceTest {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${spring.exam.manager.rest.server.url}")
	private String WEB_SERVER_REST_URL;
	
	@Test
	public void CreateExamTest(){

		Exam createExam = new Exam();
		createExam.setExamCode("testCode3");
		createExam.setExamDesc("testDesc3");
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Exam> requestEntity = new HttpEntity<Exam>(createExam,header);
		
		String url = WEB_SERVER_REST_URL+"/examAction/save_exam";
		ResponseEntity<Exam> responseEntity = restTemplate.exchange(url, HttpMethod.POST,requestEntity,Exam.class);
		Exam newExam = responseEntity.getBody();
		Assert.assertNotNull(newExam);
	}
}
