package com.example.controller.test.support;

import java.util.function.BiConsumer;

import org.mockito.stubbing.Answer;

import com.example.usecase.concept.UseCase;

public class UseCaseFactoryMocking {
    @SuppressWarnings("unchecked")
    public static <T, U> Answer<?> byPreparing(UseCase useCase, BiConsumer<T, U> toPerformAction) {
        return invocation -> {
            var request  = (T) invocation.getArgument(0);
            var responder = (U) invocation.getArgument(1);

            toPerformAction.accept(request, responder);
            return useCase;
        };
    }
}
