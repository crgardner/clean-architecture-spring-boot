package com.example.interactor.greeting.creation;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.domain.greeting.*;
import com.example.usecase.greeting.creation.*;

@DisplayName("Create Greeting Interactor")
@ExtendWith(MockitoExtension.class)
class CreateGreetingInteractorTest implements CreateGreetingResponder {
    @Mock
    private GreetingGateway greetingGateway;
    
    @Test
    @DisplayName("creates greeting")
    void createsGreeting() {
        var greeting = new Greeting("A second greeting",  new Person("Bobby"));
        when(greetingGateway.save(greeting)).thenReturn(new Greeting(2, "A second greeting",  new Person("Bobby")));

        var useCase = new CreateGreetingInteractor(greetingGateway, new CreateGreetingRequest("A second greeting", "Bobby"), this);
        useCase.execute();        
    }
    
    @Override
    public void accept(CreateGreetingResponse createGreetingResponse) {
        assertThat(createGreetingResponse).isEqualToComparingFieldByField(new CreateGreetingResponse(2L, "A second greeting", "Bobby"));
    }

}
