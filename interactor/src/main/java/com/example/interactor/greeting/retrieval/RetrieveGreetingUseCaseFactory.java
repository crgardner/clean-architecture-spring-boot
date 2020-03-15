package com.example.interactor.greeting.retrieval;

import com.example.domain.greeting.GreetingGateway;
import com.example.usecase.concept.*;
import com.example.usecase.greeting.retrieval.*;

public class RetrieveGreetingUseCaseFactory implements UseCaseFactory<RetrieveGreetingRequest, RetrieveGreetingResponder> {
    
    private final GreetingGateway greetingGateway;

    public RetrieveGreetingUseCaseFactory(GreetingGateway greetingGateway) {
        this.greetingGateway = greetingGateway;
    }

    @Override
    public UseCase create(RetrieveGreetingRequest request, RetrieveGreetingResponder responder) {
        return  doCreate(request, responder);
    }

    private RetrieveGreetingInteractor doCreate(RetrieveGreetingRequest request, RetrieveGreetingResponder responder) {
        return new RetrieveGreetingInteractor(greetingGateway, request, responder);
    }

}
