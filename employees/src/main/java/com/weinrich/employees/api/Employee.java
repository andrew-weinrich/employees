package com.weinrich.employees.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Employee {
    private int id;
    
    private String firstName;
    private String lastName;
    private String title;
    private String department;
    private String startDate;
    
    
    public Employee() {
        this.id = 1;
    }
    
    public Employee(
        String firstName,
        String lastName,
        String title,
        String department,
        String startDate)
    {
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
    private String getDepartment() {
        return department;
    }
    
    @JsonProperty("StartDate")
    private String getStartDate() {
        return startDate;
    }
    
    @JsonProperty("Id")
    private int getId() {
        return id;
    }
    
    
}