package com.example.controller.greeting.creation;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = CreateGreetingController.class)
public class CreateGreetingControllerTest {
    @Autowired
    private MockMvc mockMvc;
    
    private String greetingResourceJson;
    
    @BeforeEach
    void init() throws Exception {
        var objectMapper = new ObjectMapper();
        var greetingResource = new GreetingResource(0L, "hello from client", "Mr. Boston");
        greetingResourceJson = objectMapper.writeValueAsString(greetingResource);
    }
    
    @Test
    @DisplayName("creates new greeting")
    void createsNewGreeting() throws Exception {
        mockMvc.perform(post("/salutation/v1/greetings/")
               .contentType("application/json")
               .content(greetingResourceJson))
               .andExpect(status().isOk())
               .andExpect(content().json("{\"id\": 100, \"greetingText\": \"hello from client\"}"));
    }
}
