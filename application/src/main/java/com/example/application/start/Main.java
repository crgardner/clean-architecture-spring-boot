package com.example.application.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.application.configuration")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
