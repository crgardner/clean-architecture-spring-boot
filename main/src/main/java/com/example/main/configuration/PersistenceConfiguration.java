package com.example.main.configuration;

import java.util.function.UnaryOperator;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.main.transaction.TransactionalUseCase;
import com.example.persistence.greeting.*;
import com.example.usecase.concept.UseCase;

@Configuration
@EnableJpaRepositories("com.example.persistence")
@EntityScan("com.example.persistence")
public class PersistenceConfiguration {
    @Bean
    public SpringDataGreetingGateway springDataGreetingGateway(GreetingRepository greetingRepository) {
        return new SpringDataGreetingGateway(greetingRepository);
    }
    
    @Bean
    public UnaryOperator<UseCase> transactionalDecorator() {
        return this::transactionalUseCase;
    }

    @Bean
    @Scope("prototype")
    public UseCase transactionalUseCase(UseCase useCase) {
        return new TransactionalUseCase(useCase);
    }

}
