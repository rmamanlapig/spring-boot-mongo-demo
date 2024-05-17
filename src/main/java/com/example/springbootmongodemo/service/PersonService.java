package com.example.springbootmongodemo.service;

import com.example.springbootmongodemo.entities.Person;
import java.util.List;

public interface PersonService {

    // Add Person
    Person addPerson(Person person);

    // Get all Person
    List<Person> getAllPerson();

    // Get Person by ID
    Person getPerson(String id);

    // Update Person Info
    Person updatePersonInfo(String id, Person person);

    // Delete Person Info
    Person deletePersonInfo(String id);

}
