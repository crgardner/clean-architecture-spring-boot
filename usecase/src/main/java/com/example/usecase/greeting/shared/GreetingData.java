package com.example.usecase.greeting.shared;

public class GreetingData {
    private final Long id;
    private final String greetingText;
    private final String originator;

    public GreetingData(Long id, String greetingText, String originator) {
        this.id = id;
        this.greetingText = greetingText;
        this.originator = originator;
    }

    public Long id() {
        return id;
    }

    public String greetingText() {
        return greetingText;
    }

    public String originator() {
        return originator;
    }
}
