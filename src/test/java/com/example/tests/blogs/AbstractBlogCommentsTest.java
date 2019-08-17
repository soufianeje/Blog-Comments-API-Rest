package com.example.tests.blogs;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.blogs.CommentsBlogApplication;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = CommentsBlogApplication.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractBlogCommentsTest {
	
	@Autowired
	WebApplicationContext webAppliCxt;
	
	protected MockMvc mockMvc;

	protected void setAppliUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppliCxt).build();
	}

	protected String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objMapper = new ObjectMapper();
		return objMapper.writeValueAsString(object);
	}

	protected <T> T mapFromJson(String json, Class<T> clss)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objMapper = new ObjectMapper();
		return objMapper.readValue(json, clss);
	}
}