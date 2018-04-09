package com.weinrich.employees.core;

import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "department_id", nullable = false)
    private int id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    //private List<Employee> employees = new ArrayList<Employee>();
    
    public Department() {
        
    }
    
    public Department(int id, String name) {
        this.name = name;
        this.id = id;
    }
    /*
    @OneToMany(mappedBy="department_id")
    public List<Employee> getEmployees() {
        return new ArrayList<Employee>();
        //return this.employees;
    }
    */
}