package com.weinrich.employees.api;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Department {
    private int id;
    
    private String name;
    
    private List<Employee> employees;
    
    public Department(int id, String name) {
        this.name = name;
        this.id = id;
        
        this.employees = new ArrayList<Employee>();
        this.employees.add(new Employee(
            1,
            "Bill",
            "Smith",
            "Director",
            "Stuff",
            "12/22/2012"
        ));
    }
    
    public List<Employee> getEmployees() {
        return this.employees;
    }
}