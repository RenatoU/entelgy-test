package com.comments.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.comments.app.model.Comment;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CommentControllerIntTest {
	
	@Autowired
	private TestRestTemplate test;
	
	@Test
	public void getCommentsTest() {
		
		ResponseEntity<Comment[]> responseTest = test.postForEntity("/comment/getAll", null, Comment[].class);
		
		System.out.println(responseTest.getBody()[0].getEmail());
		assertThat(responseTest.getBody()[0].getEmail()).isEqualTo("Eliseo@gardner.biz");
		
	}

}
