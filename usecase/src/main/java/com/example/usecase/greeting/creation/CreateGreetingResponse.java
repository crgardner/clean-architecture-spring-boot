package com.example.usecase.greeting.creation;

import com.example.usecase.greeting.shared.GreetingData;

public class CreateGreetingResponse {
    private final GreetingData data;

    public CreateGreetingResponse(Long id, String greetingText, String originator) {
        this.data = new GreetingData(id, greetingText, originator);
    }

    public GreetingData data() {
        return data;
    }
}
