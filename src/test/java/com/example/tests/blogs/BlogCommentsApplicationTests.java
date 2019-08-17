package com.example.tests.blogs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.blogs.model.Blog;
import com.example.blogs.model.Comment;

public class BlogCommentsApplicationTests extends AbstractBlogCommentsTest {

	@Override
	@Before
	public void setAppliUp() {
		super.setAppliUp();
	}

	@Test
	public void createBlog() throws Exception {
		String uri = "/blogs";
		Blog blog = new Blog();
		blog.setTitle("Blog X");
		blog.setContent("Blog X");

		String jsonIn = super.mapToJson(blog);
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonIn)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Blog X");
	}
	
	@Test
	public void getCommentsList() throws Exception {
		String uri = "/blogs/1/comments";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Comment[] commentslist = super.mapFromJson(content, Comment[].class);
		assertTrue(commentslist.length > 0);
	}

	@Test
	public void createComment() throws Exception {
		String uri = "/blogs/1/comments";
		Comment comment = new Comment();
		comment.setTitle("Comment X");
		comment.setContent("Comment X for Blog 1");

		String inputJson = super.mapToJson(comment);
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Comment X for Blog 1");
	}

	@Test
	public void updateComment() throws Exception {
		String uri = "/comments/2";
		Comment comment = new Comment();
		comment.setTitle("Comment X");
		comment.setContent("Comment 2");
		String inputJson = super.mapToJson(comment);
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Comment 2");
	}

	@Test
	public void deleteComment() throws Exception {
		String uri = "/comments/2";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Comment 2");
	}
}