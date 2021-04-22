package com.comments.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comments.app.model.Comment;
import com.comments.app.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService service;
	
	@PostMapping("/getAll")
	public ResponseEntity<List<Comment>> getComments(){
		
		List<Comment> comments = service.getComments();
		
		return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
	}
	
}
