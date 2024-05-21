package com.example.springbootmongodemo.service;

import com.example.springbootmongodemo.entities.Person;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface PersonService {

    // Create Person for DB
    ResponseEntity<Person> addPerson(Person person);

    // Return all Person Data in DB
    ResponseEntity<List<Person>> getAllPerson();

    // Get Person by ID
    ResponseEntity<Person> getPersonById(String id);

    // Get Person by Full Name
    ResponseEntity<List<Person>> getPersonByName(String firstName, String lastName);

    // Update Person
    ResponseEntity<Person> updatePerson(String id, Person person);

    // Delete Person Info
    ResponseEntity<String> deletePerson(String id);

}
