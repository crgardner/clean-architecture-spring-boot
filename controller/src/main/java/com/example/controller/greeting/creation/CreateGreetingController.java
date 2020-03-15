package com.example.controller.greeting.creation;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.usecase.concept.*;
import com.example.usecase.greeting.creation.*;
import com.example.webmvc.response.ResponseEntityResponseWriter;

@RestController
public class CreateGreetingController {

    private final UseCaseFactory<CreateGreetingRequest, CreateGreetingResponder> useCaseFactory;

    public CreateGreetingController(UseCaseFactory<CreateGreetingRequest, CreateGreetingResponder> useCaseFactory) {
        this.useCaseFactory = useCaseFactory;
    }

    @PostMapping(value = "/salutation/v1/greetings", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createGreeting(@RequestBody GreetingResource resource) {
        var responseWriter = new ResponseEntityResponseWriter();
        var useCase = createUseCase(resource, responseWriter);

        useCase.execute();

        return responseWriter.getResponseEntity();
    }

    private UseCase createUseCase(GreetingResource greetingResource, ResponseEntityResponseWriter responseWriter) {
        return useCaseFactory.create(requestFrom(greetingResource), presenterFor(responseWriter));
    }

    private CreateGreetingPresenter presenterFor(ResponseEntityResponseWriter responseWriter) {
        return new CreateGreetingPresenter(responseWriter);
    }

    private CreateGreetingRequest requestFrom(GreetingResource greetingResource) {
        return new CreateGreetingRequest(greetingResource.getGreetingText(), greetingResource.getOriginator());
    }
}
