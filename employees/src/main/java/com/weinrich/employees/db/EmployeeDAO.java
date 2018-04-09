package com.weinrich.employees.db;

import com.weinrich.employees.api.Employee;

import com.weinrich.employees.db.EmployeeDAOInterface;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.*;


public class EmployeeDAO extends AbstractDAO<Employee> implements EmployeeDAOInterface {
    public EmployeeDAO(SessionFactory factory) {
        super(factory);
    }
    
    public List<Employee> findEmployeesByName(String lastName, String firstName) {
        return new ArrayList<Employee>();
    }

    public Employee createEmployee(Employee employee) {
        return employee;
    }
}