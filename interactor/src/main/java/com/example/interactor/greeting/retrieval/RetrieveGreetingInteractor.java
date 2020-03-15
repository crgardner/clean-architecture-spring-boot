package com.example.interactor.greeting.retrieval;

import com.example.domain.greeting.*;
import com.example.usecase.concept.UseCase;
import com.example.usecase.greeting.retrieval.*;

public class RetrieveGreetingInteractor implements UseCase {
    private final GreetingGateway greetingGateway;
    private final RetrieveGreetingRequest request;
    private final RetrieveGreetingResponder responder;
    
    public RetrieveGreetingInteractor(GreetingGateway greetingGateway, RetrieveGreetingRequest request, RetrieveGreetingResponder responder) {
        this.greetingGateway = greetingGateway;
        this.request = request;
        this.responder = responder;
    }

    @Override
    public void execute() {
        var possibleGreeting = greetingGateway.findGreetingById(request.id());
        Greeting greeting = possibleGreeting.get();

        var response = new RetrieveGreetingResponse(greeting.id(), greeting.text(), greeting.originator().name());
        responder.accept(response);
    }

}
