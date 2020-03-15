package com.example.main.configuration;

import org.springframework.context.annotation.*;

import com.example.interactor.greeting.creation.CreateGreetingUseCaseFactory;
import com.example.usecase.concept.UseCaseFactory;
import com.example.usecase.greeting.creation.*;

@Configuration
public class InteractorConfiguration {
    @Bean
    public UseCaseFactory<CreateGreetingRequest, CreateGreetingResponder> createGreetingUseCaseFactory() {
        return new CreateGreetingUseCaseFactory();
    }
}
