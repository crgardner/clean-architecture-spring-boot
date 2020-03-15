package com.example.usecase.greeting.retrieval;

import com.example.usecase.greeting.shared.GreetingData;

public class RetrieveGreetingResponse  {
    private final GreetingData data;

    public RetrieveGreetingResponse(Long id, String text, String originator) {
        this.data = new GreetingData(id, text, originator);
    }
    
    public GreetingData data() {
        return data;
    }

    

}
