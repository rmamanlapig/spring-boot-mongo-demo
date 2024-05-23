package com.example.springbootmongodemo.repositories;

import com.example.springbootmongodemo.entities.Person;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

    @Query("{ '$and' : [{'firstName' : '?0'}, {'lastName' : ?1}] }")
    Optional<List<Person>> findByName(String firstName, String lastName);
}
