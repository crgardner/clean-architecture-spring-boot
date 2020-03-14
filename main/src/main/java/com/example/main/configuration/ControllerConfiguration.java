package com.example.main.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.controller.greeting.creation.CreateGreetingController;

@Configuration
public class ControllerConfiguration {
    @Bean
    public CreateGreetingController createGreetingController() {
        return new CreateGreetingController();
    }
}
