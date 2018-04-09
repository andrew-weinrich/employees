package com.weinrich.employees.api;

import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "department")
@NamedQueries(
    {
        @NamedQuery(
            name = "com.weinrich.employees.api.Department.findDepartmentByName",
            query = "SELECT d FROM Department d WHERE name = :name"
        )
    })
public class Department {
    @Id
    @Column(name = "department_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    
    public List<Employee> getEmployees() {
        return new ArrayList<Employee>();
        //return this.employees;
    }
}