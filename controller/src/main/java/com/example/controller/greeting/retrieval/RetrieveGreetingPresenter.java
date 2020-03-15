package com.example.controller.greeting.retrieval;

import com.example.controller.greeting.creation.GreetingResource;
import com.example.controller.response.ResponseWriter;
import com.example.usecase.greeting.retrieval.*;

public class RetrieveGreetingPresenter implements RetrieveGreetingResponder {

    private final ResponseWriter responseWriter;

    RetrieveGreetingPresenter(ResponseWriter responseWriter) {
        this.responseWriter = responseWriter;
    }

    @Override
    public void accept(RetrieveGreetingResponse response) {
        responseWriter.ok(createGreetingResource(response));
    }

    private GreetingResource createGreetingResource(RetrieveGreetingResponse response) {
        var data = response.data();
        
        return new GreetingResource(data.id(),
                                    data.greetingText(),
                                    data.originator());
    }
}
