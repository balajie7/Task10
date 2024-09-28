package com.example.task10.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Employee {

    @Id
    private String id;
    private String employeeId;
    private String name;
    private String email;
    private String location;

}
