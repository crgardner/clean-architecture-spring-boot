package com.example.controller.greeting.retrieval;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.usecase.concept.UseCaseFactory;
import com.example.usecase.greeting.retrieval.*;
import com.example.webmvc.response.ResponseEntityResponseWriter;

@RestController
public class RetrieveGreetingController {
    private final UseCaseFactory<RetrieveGreetingRequest, RetrieveGreetingResponder> useCaseFactory;

    public RetrieveGreetingController(
            UseCaseFactory<RetrieveGreetingRequest, RetrieveGreetingResponder> useCaseFactory) {
        this.useCaseFactory = useCaseFactory;
    }

    @GetMapping(value = "/salutation/v1/greetings/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getGreeting(@PathVariable("id") Long id) {
        var responseWriter = new ResponseEntityResponseWriter();
        var presenter = new RetrieveGreetingPresenter(responseWriter);
        var useCase = useCaseFactory.create(new RetrieveGreetingRequest(id), presenter);

        useCase.execute();

        return responseWriter.getResponseEntity();
    }
}
