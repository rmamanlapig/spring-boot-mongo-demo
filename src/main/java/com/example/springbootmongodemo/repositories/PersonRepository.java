package com.example.springbootmongodemo.repositories;

import com.example.springbootmongodemo.entities.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
