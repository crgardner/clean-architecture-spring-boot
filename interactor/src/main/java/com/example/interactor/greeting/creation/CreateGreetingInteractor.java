package com.example.interactor.greeting.creation;

import com.example.domain.greeting.*;
import com.example.usecase.concept.UseCase;
import com.example.usecase.greeting.creation.*;

class CreateGreetingInteractor implements UseCase {

    private final CreateGreetingRequest request;
    private final CreateGreetingResponder responder;

    CreateGreetingInteractor(CreateGreetingRequest request, CreateGreetingResponder responder) {
        this.request = request;
        this.responder = responder;
    }

    @Override
    public void execute() {
        var greeting = createGreeting();

        responder.accept(createGreetingResponseFrom(greeting));
    }

    private Greeting createGreeting() {
        return new Greeting(request.greetingText(), new Person(request.originator()));
    }

    private CreateGreetingResponse createGreetingResponseFrom(Greeting greeting) {
        return new CreateGreetingResponse(greeting.id(), greeting.text(), greeting.originator().name());
    }
}
