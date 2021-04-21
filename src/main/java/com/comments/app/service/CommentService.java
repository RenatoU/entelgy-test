package com.comments.app.service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.comments.app.model.Comment;
import com.comments.app.model.CommentResponse;

@Service
public class CommentService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private Environment env;	
	
	public List<Comment> getComments(){
		
		ResponseEntity<CommentResponse[]> response = restTemplate.getForEntity(env.getProperty("web.service"), CommentResponse[].class);
		
		List<CommentResponse> commentsResponse = Arrays.asList(response.getBody());
		List<Comment> comments = responseToComment(commentsResponse);
		
		return comments;
	}
	
	public List<Comment> responseToComment(List<CommentResponse> response){
		
		List<Comment> comments = new ArrayList<>();
		Comment com = null;
		
		for (CommentResponse comment : response) {
			com = new Comment();
			com.setPostId(comment.getPostId());
			com.setId(comment.getId());
			com.setEmail(comment.getEmail());
			comments.add(com);
		}
		
		return comments;
	}
	
}




