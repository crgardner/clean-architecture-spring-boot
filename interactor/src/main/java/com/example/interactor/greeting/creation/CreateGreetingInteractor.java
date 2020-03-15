package com.example.interactor.greeting.creation;

import com.example.domain.greeting.*;
import com.example.usecase.concept.UseCase;
import com.example.usecase.greeting.creation.*;

class CreateGreetingInteractor implements UseCase {

    private final GreetingGateway greetingGateway;
    private final CreateGreetingRequest request;
    private final CreateGreetingResponder responder;

    CreateGreetingInteractor(GreetingGateway greetingGateway, CreateGreetingRequest request, CreateGreetingResponder responder) {
        this.greetingGateway = greetingGateway;
        this.request = request;
        this.responder = responder;
    }

    @Override
    public void execute() {
        var greeting = save(createGreeting());

        responder.accept(createGreetingResponseFrom(greeting));
    }

    private Greeting createGreeting() {
        return new Greeting(request.greetingText(), new Person(request.originator()));
    }

    private Greeting save(Greeting greeting) {
        return greetingGateway.save(greeting);
    }

    private CreateGreetingResponse createGreetingResponseFrom(Greeting greeting) {
        return new CreateGreetingResponse(greeting.id(), greeting.text(), greeting.originator().name());
    }
}
