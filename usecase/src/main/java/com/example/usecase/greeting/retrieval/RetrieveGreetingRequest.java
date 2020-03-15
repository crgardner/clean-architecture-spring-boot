package com.example.usecase.greeting.retrieval;

public class RetrieveGreetingRequest {
    private final Long id;

    public RetrieveGreetingRequest(Long id) {
        this.id = id;
    }
    
    public Long id() {
        return id;
    }
}
