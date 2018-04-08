package com.weinrich.employees.api;

import java.util.*;

import com.weinrich.employees.api.Department;

public class Title {
    private int id;
    
    private String name;
    
    private Department department;
    
    public Title(int id, String name, Department department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }
    
    public Department getDepartment() {
        return this.department;
    }
}