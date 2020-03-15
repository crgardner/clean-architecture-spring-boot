package com.example.persistence.greeting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.greeting.Greeting;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long> {

}
