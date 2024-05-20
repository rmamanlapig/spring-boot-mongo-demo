package com.example.springbootmongodemo.service.impl;

import com.example.springbootmongodemo.entities.Person;
import com.example.springbootmongodemo.repositories.PersonRepository;
import com.example.springbootmongodemo.service.PersonService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person addPerson(Person person) {
        return this.personRepository.save(person);
    }

    public List<Person> getAllPerson() {
        return this.personRepository.findAll();
    }
//
//    @Override
//    public Person getPerson(String id) {
//        return null;
//    }
//
//    @Override
//    public Person updatePersonInfo(String id, Person person) {
//        return null;
//    }
//
//    @Override
//    public Person deletePersonInfo(String id) {
//        return null;
//    }
}
