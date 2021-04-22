package com.comments.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comments.app.model.Comment;
import com.comments.app.model.CommentResponse;
import com.comments.app.repo.CommentRepo;

@Service
public class CommentService {
	
	@Autowired
	CommentRepo repo;
	
	public List<Comment> getComments(){
		
		List<Comment> comments = responseToComment(repo.getCommentsResponse());
		
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




