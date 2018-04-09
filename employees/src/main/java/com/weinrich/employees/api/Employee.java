package com.weinrich.employees.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import com.weinrich.employees.core.*;

import java.util.*;
import java.text.*;

/*
@Entity
@Table(name = "people")
@NamedQueries(
    {
        @NamedQuery(
            name = "com.example.helloworld.core.Person.findAll",
            query = "SELECT p FROM Person p"
        )
    })
        */
public class Employee {
    
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    //@Column(name = "firstName", nullable = false)
    private String firstName;

    //@Column(name = "firstName", nullable = false)
    private String lastName;

    //@Column(name = "firstName", nullable = false)
    private String title;

    //@Column(name = "firstName", nullable = false)
    private String department;

    //@Column(name = "firstName", nullable = false)
    private Date startDateNative;
    
    private String startDate;
    
    private static final StrictSimpleDateFormat dateFormat =
        new StrictSimpleDateFormat("MM/dd/yyyy", "\\d\\d/\\d\\d/\\d\\d\\d\\d");
    
    /**
     * Returns the format used for the startDate property.
     */
    public static StrictSimpleDateFormat getDateFormat() {
        return dateFormat;
    }
    
    
    
    public Employee() {
        
    }
    
    public Employee(
        int id,
        String firstName,
        String lastName,
        String title,
        String department,
        String startDate)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.department = department;
        this.startDate = startDate;
    }
    
    
    @JsonProperty("FirstName")
    public String getFirstName() {
        return firstName;
    }
    
    @JsonProperty("LastName")
    public String getLastName() {
        return lastName;
    }
    
    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }
    
    @JsonProperty("Department")
    public String getDepartment() {
        return department;
    }
    
    @JsonProperty("StartDate")
    public String getStartDate() {
        return startDate;
    }
    
    @JsonProperty("Id")
    public int getId() {
        return id;
    }
    
    
}