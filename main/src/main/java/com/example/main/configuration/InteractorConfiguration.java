package com.example.main.configuration;

import java.util.function.UnaryOperator;

import org.springframework.context.annotation.*;

import com.example.interactor.greeting.creation.CreateGreetingUseCaseFactory;
import com.example.persistence.greeting.SpringDataGreetingGateway;
import com.example.usecase.concept.*;
import com.example.usecase.greeting.creation.*;

@Configuration
public class InteractorConfiguration {
    @Bean
    public UseCaseFactory<CreateGreetingRequest, CreateGreetingResponder> createGreetingUseCaseFactory(
            UnaryOperator<UseCase> transactionalDecorator,
            SpringDataGreetingGateway springDataGreetingGateway) {
        return new CreateGreetingUseCaseFactory(springDataGreetingGateway, transactionalDecorator);
    }
}
