package com.example.main.transaction;

import com.example.usecase.concept.UseCase;

public class TransactionalUseCase implements UseCase {
    private final UseCase useCase;

    public TransactionalUseCase(UseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    @javax.transaction.Transactional
    public void execute() {
        useCase.execute();
    }

}
