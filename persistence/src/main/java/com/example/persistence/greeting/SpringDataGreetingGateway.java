package com.example.persistence.greeting;


import java.util.Optional;

import com.example.domain.greeting.*;

public class SpringDataGreetingGateway implements GreetingGateway {
    private final GreetingRepository greetingRepository;

    public SpringDataGreetingGateway(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public Optional<Greeting> findGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    @Override
    public Greeting save(Greeting greeting) {
        return greetingRepository.save(greeting);
    }
}
