package com.weinrich.employees.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

import com.weinrich.employees.core.*;

import java.util.*;
import java.text.*;


@Entity
@Table(name = "employee")
@NamedQueries(
    {
        @NamedQuery(
            name = "com.weinrich.employees.core.Employee.findEmployeesByDepartment",
            query = "SELECT e " +
                    "FROM Employee e " +
                    "    INNER JOIN e.title AS t " +
                    "    INNER JOIN t.department AS d  " +
                    "WHERE d.name = :departmentName"
        ),
        @NamedQuery(
            name = "com.weinrich.employees.core.Employee.getEmployeeById",
            query = "SELECT e FROM Employee e where e.id = :id"
        )
    })
/**
 * Class for employees. Employees with the same name/title/department can exist so long as they have unique IDs.
 * Employees are linked to their department through their title.
 */
public class Employee {
    @Id
    @Column(name = "employee_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=Title.class )
    @JoinColumn(name="title_id")
    private Title title;

    @Column(name = "start_date", nullable = false)
    private Date startDate;
    
    
    public Employee() {
        
    }
    
    public Employee(
        String firstName,
        String lastName,
        Title title,
        Date startDate)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.startDate = startDate;
    }
    
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public Title getTitle() {
        return title;
    }
    
    public Date getStartDate() {
        return startDate;
    }
    
    public int getId() {
        return id;
    }
    
    
}