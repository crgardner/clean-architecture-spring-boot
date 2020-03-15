package com.example.interactor.greeting.creation;

import java.util.function.UnaryOperator;

import com.example.domain.greeting.GreetingGateway;
import com.example.usecase.concept.*;
import com.example.usecase.greeting.creation.*;

public class CreateGreetingUseCaseFactory implements UseCaseFactory<CreateGreetingRequest, CreateGreetingResponder> {
    
    private final GreetingGateway greetingGateway;
    private final UnaryOperator<UseCase> transactionDecorator;
    
    public CreateGreetingUseCaseFactory(GreetingGateway greetingGateway, UnaryOperator<UseCase> transactionDecorator) {
        this.greetingGateway = greetingGateway;
        this.transactionDecorator = transactionDecorator;
    }

    @Override
    public UseCase create(CreateGreetingRequest request, CreateGreetingResponder responder) {
        return transactionDecorator.apply(doCreate(request, responder));
    }

    private CreateGreetingInteractor doCreate(CreateGreetingRequest request, CreateGreetingResponder responder) {
        return new CreateGreetingInteractor(greetingGateway, request, responder);
    }

}
