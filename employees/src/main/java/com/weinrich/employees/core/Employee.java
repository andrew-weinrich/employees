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
            name = "com.weinrich.employees.core.Employee.findEmployeesByDepartmentName",
            query = "SELECT e "
                    "FROM Department d" +
                    "    INNER JOIN Title t "
                    "    INNER JOIN Employee e"
                    "WHERE d.name = :name"
        )
    })
public class Employee {
    @Id
    @Column(name = "employee_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @OneToOne
	@PrimaryKeyJoinColumn
    private Title title;

    @Column(name = "startDate", nullable = false)
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
    
    public Title getTitle() {
        return title;
    }
    
    @JsonProperty("Title")
    public String getTitleString() {
        return title.getName();
    }
    
    @JsonProperty("Department")
    public String getDepartmentString() {
        return title.getDepartment().getName();
    }
    
    @JsonProperty("StartDate")
    public String getStartDate() {
        if (startDate == null)
            startDate = 
        return startDate;
    }
    
    public String getStartDateNative() {
        if (startDateNative == null)
            startDateNative = Employee.getDateFormat().parse(getStartDate());
        return startDateNative;
    }
    
    @JsonProperty("Id")
    public int getId() {
        return id;
    }
    
    
}