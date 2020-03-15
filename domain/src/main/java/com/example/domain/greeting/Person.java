package com.example.domain.greeting;

import java.util.Objects;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    private Person() {
        // no-arg
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
