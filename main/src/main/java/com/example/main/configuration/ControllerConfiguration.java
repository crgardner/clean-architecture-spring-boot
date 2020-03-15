package com.example.main.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.controller.greeting.creation.CreateGreetingController;
import com.example.usecase.concept.UseCaseFactory;
import com.example.usecase.greeting.creation.*;

@Configuration
public class ControllerConfiguration {
    @Bean
    public CreateGreetingController createGreetingController(
            UseCaseFactory<CreateGreetingRequest, CreateGreetingResponder> createGreetingUseCaseFactory) {
     
        return new CreateGreetingController(createGreetingUseCaseFactory);
    }
}
