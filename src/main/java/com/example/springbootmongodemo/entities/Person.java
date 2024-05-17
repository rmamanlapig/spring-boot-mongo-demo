package com.example.springbootmongodemo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "openAPI-demo-db")
public record Person(@Id String id,
                     String firstName,
                     String lastName,
                     Integer age,
                     boolean isStudying){
}
