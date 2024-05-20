package com.example.springbootmongodemo.service;

import com.example.springbootmongodemo.entities.Person;
import java.util.List;

public interface PersonService {

    // Create Person for DB
    Person addPerson(Person person);

    // Return all Person
    List<Person> getAllPerson();
//
//    // Get Person by ID
//    Person getPerson(String id);
//
//    // Update Person Info
//    Person updatePersonInfo(String id, Person person);
//
//    // Delete Person Info
//    Person deletePersonInfo(String id);

}
