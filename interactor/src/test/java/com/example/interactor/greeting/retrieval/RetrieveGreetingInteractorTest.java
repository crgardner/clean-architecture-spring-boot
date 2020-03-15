package com.example.interactor.greeting.retrieval;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.domain.greeting.*;
import com.example.usecase.greeting.retrieval.*;
import com.example.usecase.greeting.shared.GreetingData;

@DisplayName("RetrieveGreetingInteractor")
@ExtendWith(MockitoExtension.class)
public class RetrieveGreetingInteractorTest implements RetrieveGreetingResponder {
    @Mock
    private GreetingGateway greetingGateway;
    
    @Test
    @DisplayName("retrieves requested greeting")
    void createsGreeting() {
        var greeting = new Greeting(2L, "A second greeting",  new Person("Bobby"));
        var possibleGreeting = Optional.of(
                greeting);
        when(greetingGateway.findGreetingById(2L)).thenReturn(possibleGreeting);

        var useCase = new RetrieveGreetingInteractor(greetingGateway, new RetrieveGreetingRequest(2L), this);
        useCase.execute();        
    }
    
    @Override
    public void accept(RetrieveGreetingResponse response) {
        assertThat(response.data()).isEqualToComparingFieldByField(new GreetingData(2L, "A second greeting", "Bobby"));
    }

}
