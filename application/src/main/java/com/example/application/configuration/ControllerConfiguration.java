package com.example.application.configuration;

import org.springframework.context.annotation.*;

import com.example.controller.greeting.creation.CreateGreetingController;
import com.example.controller.greeting.retrieval.RetrieveGreetingController;
import com.example.usecase.concept.UseCaseFactory;
import com.example.usecase.greeting.creation.*;
import com.example.usecase.greeting.retrieval.*;

@Configuration
public class ControllerConfiguration {
    @Bean
    public CreateGreetingController createGreetingController(
            UseCaseFactory<CreateGreetingRequest, CreateGreetingResponder> createGreetingUseCaseFactory) {
     
        return new CreateGreetingController(createGreetingUseCaseFactory);
    }
    
    @Bean
    public RetrieveGreetingController retrieveGreetingController(
            UseCaseFactory<RetrieveGreetingRequest, RetrieveGreetingResponder> retrieveGreetingUseCaseFactory) {
     
        return new RetrieveGreetingController(retrieveGreetingUseCaseFactory);
    }
}
