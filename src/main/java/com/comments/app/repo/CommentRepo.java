package com.comments.app.repo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.comments.app.model.CommentResponse;

@Repository
public class CommentRepo {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private Environment env;

	public List<CommentResponse> getCommentsResponse(){
		
		ResponseEntity<CommentResponse[]> response = restTemplate.getForEntity(env.getProperty("web.service"), CommentResponse[].class);
		
		List<CommentResponse> commentsResponse = Arrays.asList(response.getBody());
		
		return commentsResponse;
	}
	
}
