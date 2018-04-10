package com.weinrich.employees.core;

import java.util.*;

import javax.persistence.*;

import com.weinrich.employees.core.Department;

@Entity
@Table(name = "title")
@NamedQueries(
    {
        @NamedQuery(
            name = "com.weinrich.employees.core.Title.getTitleByNameAndDepartment",
            query = "SELECT t FROM Title t JOIN Department d ON t.department = d WHERE t.name = :titleName AND d.name = :departmentName"
        )
    })
/**
 * Class for titles. The same title string (e.g. 'Analyst') can exist in different departments while denoting different jobs.
 */
public class Title {
    @Id
    @Column(name = "title_id", nullable = false)
    private int id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=Department.class )
    @JoinColumn(name="department_id")
    private Department department;
    
    public Title() {
        
    }
    
    public Department getDepartment() {
        return this.department;
    }
    
    public String getName() {
        return this.name;
    }
}