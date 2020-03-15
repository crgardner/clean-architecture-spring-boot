package com.example.controller.greeting.retrieval;

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

import com.example.controller.greeting.creation.GreetingResource;
import com.example.usecase.concept.*;
import com.example.usecase.greeting.retrieval.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = RetrieveGreetingController.class)
@DisplayName("RetrieveGreetingController")
public class RetrieveGreetingControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UseCaseFactory<RetrieveGreetingRequest, RetrieveGreetingResponder> useCaseFactory;

    @Mock
    private UseCase useCase;

    private String greetingResourceJson;

    @BeforeEach
    void init() throws Exception {
        var objectMapper = new ObjectMapper();
        var greetingResource = new GreetingResource(1L, "hello from client", "Mr. Boston");
        greetingResourceJson = objectMapper.writeValueAsString(greetingResource);
    }

    @Test
    @DisplayName("retrieves existing greeting")
    void retrievesExistingGreeting() throws Exception {
        when(useCaseFactory.create(any(), any())).thenAnswer(byPreparing(useCase, toRunMainFlow()));

        mockMvc.perform(get("/salutation/v1/greetings/1"))
               .andExpect(status().isOk())
               .andExpect(content().json(greetingResourceJson));
    }

    private BiConsumer<RetrieveGreetingRequest, RetrieveGreetingResponder> toRunMainFlow() {
        return (request, responder) -> {
            doAnswer(invocation -> {
                responder.accept(new RetrieveGreetingResponse(1L, "hello from client", "Mr. Boston"));
                return null;
            }).when(useCase).execute();
        };
    }

}
