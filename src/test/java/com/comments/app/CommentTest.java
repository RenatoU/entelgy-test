package com.comments.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.comments.app.model.Comment;
import com.comments.app.service.CommentService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CommentTest {
	
	private CommentService service = Mockito.mock(CommentService.class);
	
	@BeforeEach
	void setUp() {
		List<Comment> commentsMock = new ArrayList<>();
		Comment c1 = new Comment();
		c1.setPostId(4);
		c1.setId(3);
		c1.setEmail("test@gmail.com");
		commentsMock.add(c1);
		
		when(service.getComments()).thenReturn(commentsMock);
	}
	
	@Test
	public void commentTest() {
		
		List<Comment> list = service.getComments();
		
		assertThat("test@gmail.com").isEqualTo(list.get(0).getEmail());
		System.out.println(list.get(0).getEmail());
	}

}



