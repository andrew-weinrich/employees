package com.weinrich.employees.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import com.weinrich.employees.core.*;

import java.util.*;
import java.text.*;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String title;
    private String department;
    private String startDate;
    
    
    private static final StrictSimpleDateFormat dateFormat;
    
    public static StrictSimpleDateFormat getDateFormat() {
        return dateFormat;
    }
    
    static {
        dateFormat = new StrictSimpleDateFormat("MM/dd/yyyy", "\\d\\d/\\d\\d/\\d\\d\\d\\d");
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