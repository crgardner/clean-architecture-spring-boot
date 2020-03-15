package com.example.interactor.greeting.creation;

import com.example.usecase.concept.*;
import com.example.usecase.greeting.creation.*;

public class CreateGreetingUseCaseFactory implements UseCaseFactory<CreateGreetingRequest, CreateGreetingResponder> {

    @Override
    public UseCase create(CreateGreetingRequest request, CreateGreetingResponder responder) {
        return new CreateGreetingInteractor(request, responder);
    }

}
