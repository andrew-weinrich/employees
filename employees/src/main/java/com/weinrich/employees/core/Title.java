package com.weinrich.employees.core;

import java.util.*;

import javax.persistence.*;

import com.weinrich.employees.core.Department;

@Entity
@Table(name = "department")
public class Title {
    @Id
    @Column(name = "title_id", nullable = false)
    private int id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @OneToOne
	@PrimaryKeyJoinColumn
    private Department department;
    
    public Title(int id, String name, Department department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }
    
    public Department getDepartment() {
        return this.department;
    }
    
    public String getName() {
        return this.name;
    }
}