package com.example.springbootmongodemo.controller;

import com.example.springbootmongodemo.entities.Person;
import com.example.springbootmongodemo.service.PersonService;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(value = "/addPerson", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }

    @GetMapping(value = "/getAllPerson", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Person>> getAllPerson(){
        return personService.getAllPerson();
    }

    @GetMapping(value = "/getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> getPersonById(@PathVariable String id){
        return personService.getPersonById(id);
    }

    @GetMapping(value = "/getPersonByName/{firstName}/{lastName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Person>> getPersonByName(@PathVariable String firstName, @PathVariable String lastName){
        return personService.getPersonByName(firstName, lastName);
    }

    @PatchMapping(value = "/updatePerson/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> updatePerson(@PathVariable String id, @RequestBody Person person){
        return personService.updatePerson(id, person);
    }

    @DeleteMapping(value = "/deletePerson/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deletePerson(@PathVariable String id){
        return personService.deletePerson(id);
    }
}
