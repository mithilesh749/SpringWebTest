package com.mithilesh.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mithilesh.test.entity.ThemeParkRide;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class SpringWebTestApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getAllRides() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/ride")
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void getSingleRides() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/ride/1")
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void returnsNotFoundForInvalidSingleRideFind() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/ride/6")
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isNotFound())
				.andReturn();
	}

	@Test
	public void addNewRide() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		ThemeParkRide ride = new ThemeParkRide("Test Ride", "Test ride desc", 2, 4);
		mockMvc.perform(MockMvcRequestBuilders.post("/ride")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(mapper.writeValueAsString(ride)))
				.andExpect(status().isOk())
				.andReturn();
	}

}
