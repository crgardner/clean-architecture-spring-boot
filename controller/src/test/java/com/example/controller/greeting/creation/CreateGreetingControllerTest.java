package com.example.controller.greeting.creation;

import static com.example.controller.test.support.UseCaseFactoryMocking.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.function.BiConsumer;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.usecase.concept.*;
import com.example.usecase.greeting.creation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = CreateGreetingController.class)
@DisplayName("CreateGreetingController")
public class CreateGreetingControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UseCaseFactory<CreateGreetingRequest, CreateGreetingResponder> useCaseFactory;

    @Mock
    private UseCase useCase;

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
        when(useCaseFactory.create(any(), any())).thenAnswer(byPreparing(useCase, toRunMainFlow()));

        mockMvc.perform(post("/salutation/v1/greetings/").contentType("application/json").content(greetingResourceJson))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 1, \"greetingText\": \"hello from client\"}"));
    }

    private BiConsumer<CreateGreetingRequest, CreateGreetingResponder> toRunMainFlow() {
        return (request, responder) -> {
            doAnswer(invocation -> {
                responder.accept(new CreateGreetingResponse(1L, request.greetingText(), request.originator()));
                return null;
            }).when(useCase).execute();
        };
    }

}
