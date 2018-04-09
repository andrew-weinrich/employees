package com.weinrich.employees.core;

import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "department")
@NamedQueries(
    {
        @NamedQuery(
            name = "com.weinrich.employees.core.Department.getDepartmentByName",
            query = "SELECT d FROM Department d WHERE d.name = :name"
        )
    })
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
    
    public String getName() {
        return this.name;
    }
}