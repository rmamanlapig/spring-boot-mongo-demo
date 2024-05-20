package com.example.springbootmongodemo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person
{
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    boolean isStudying;
}
