package com.example.controller.greeting.creation;

import com.example.controller.response.ResponseWriter;
import com.example.usecase.greeting.creation.*;

public class CreateGreetingPresenter implements CreateGreetingResponder {
    private final ResponseWriter responseWriter;

    public CreateGreetingPresenter(ResponseWriter responseWriter) {
        this.responseWriter = responseWriter;
    }

    @Override
    public void accept(CreateGreetingResponse response) {
        var greetingResource = createGreetingResource(response);
        
        responseWriter.ok(greetingResource);
    }

    private GreetingResource createGreetingResource(CreateGreetingResponse response) {
        var data = response.data();
        
        return new GreetingResource(data.id(),
                                    data.greetingText(),
                                    data.originator());
    }

}
