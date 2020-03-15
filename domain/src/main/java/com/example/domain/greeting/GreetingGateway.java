package com.example.domain.greeting;

import java.util.Optional;

public interface GreetingGateway {
    Optional<Greeting> findGreetingById(Long id);

    Greeting save(Greeting greeting);
}
