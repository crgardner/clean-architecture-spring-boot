package com.example.controller.greeting.creation;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateGreetingController {
    
    @PostMapping(value = "/salutation/v1/greetings", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createGreeting(@RequestBody GreetingResource resource) {
        resource.setId(100L);
        return ResponseEntity.ok(resource);
    }
}
