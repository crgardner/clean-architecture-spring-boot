package com.example.main.configuration;

import java.util.function.UnaryOperator;

import org.springframework.context.annotation.*;

import com.example.interactor.greeting.creation.CreateGreetingUseCaseFactory;
import com.example.interactor.greeting.retrieval.RetrieveGreetingUseCaseFactory;
import com.example.persistence.greeting.SpringDataGreetingGateway;
import com.example.usecase.concept.*;
import com.example.usecase.greeting.creation.*;
import com.example.usecase.greeting.retrieval.*;

@Configuration
public class InteractorConfiguration {
    @Bean
    public UseCaseFactory<CreateGreetingRequest, CreateGreetingResponder> createGreetingUseCaseFactory(
            UnaryOperator<UseCase> transactionalDecorator,
            SpringDataGreetingGateway springDataGreetingGateway) {
        return new CreateGreetingUseCaseFactory(springDataGreetingGateway, transactionalDecorator);
    }
    
    @Bean
    public UseCaseFactory<RetrieveGreetingRequest, RetrieveGreetingResponder> retrieveGreetingUseCaseFactory(
            SpringDataGreetingGateway springDataGreetingGateway) {
        
        return new RetrieveGreetingUseCaseFactory(springDataGreetingGateway);
    }
}
