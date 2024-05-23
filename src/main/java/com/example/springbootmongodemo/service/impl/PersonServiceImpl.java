package com.example.springbootmongodemo.service.impl;

import com.example.springbootmongodemo.entities.Person;
import com.example.springbootmongodemo.repositories.PersonRepository;
import com.example.springbootmongodemo.service.PersonService;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    Logger logger = Logger.getLogger(getClass().getName());

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public ResponseEntity<Person> addPerson(Person person) {
        logger.log(Level.INFO,"Starting addPerson");
        this.personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Person>> getAllPerson() {
        logger.log(Level.INFO,"Starting getAllPerson");
        List<Person> personList = personRepository.findAll();
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Person> getPersonById(String id) {
        logger.log(Level.INFO,"Starting getPersonById");
        Optional<Person> existingPerson = personRepository.findById(id);
        if (existingPerson.isPresent()) {
            return new ResponseEntity<>(existingPerson.get(), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Person>> getPersonByName(String firstName, String lastName) {
        logger.log(Level.INFO,"Starting getPersonByName");
        Optional<List<Person>> personList = personRepository.findByName(firstName, lastName);
        if (personList.isPresent()){
            if (personList.get().isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(personList.get(), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // Encountering Issues
    @Override
    public ResponseEntity<Person> updatePerson(String id, Person person) {
        logger.log(Level.INFO,"Starting updatePerson");
        Optional<Person> idValue = personRepository.findById(id);
        if (idValue.isPresent()) {
            Person existingPerson = idValue.get();
            existingPerson.setAge(person.getAge());
            existingPerson.setFirstName(person.getFirstName());
            existingPerson.setLastName(person.getLastName());
            existingPerson.setStudying(person.isStudying());

            personRepository.save(existingPerson);

            return new ResponseEntity<>(person, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> deletePerson(String id) {
        logger.log(Level.INFO,"Starting deletePerson");
        Optional<Person> idValue = personRepository.findById(id);
        if (idValue.isPresent()){
            personRepository.deleteById(id);

            return new ResponseEntity<>("Person Info Deleted", HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
