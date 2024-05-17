package com.example.springbootmongodemo.controller;

import com.example.springbootmongodemo.entities.Person;
import com.example.springbootmongodemo.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value="/")
    public void homeRedirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/index.html");
    }

    @Operation(summary = "Add a Person Info", description = "We are adding a Person's info the the DB", tags = {"person", "post"})
    @ApiResponses({@ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = Person.class), mediaType = "application/json")})})
    @PostMapping(value="/person")
    public ResponseEntity<Person> addPerson (@RequestBody Person person){
        return new ResponseEntity<>(this.personService.addPerson(person), HttpStatus.CREATED);
    }

    @Operation(summary = "Get all Person Info", description = "We are getting all the Person info in the DB", tags = {"person", "get"})
    @ApiResponses({@ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = List.class), mediaType = "application/json")})})
    @GetMapping(value="/person")
    public ResponseEntity<List<Person>> getAllPerson(){
        return ResponseEntity.ok(this.personService.getAllPerson());
    }
}
