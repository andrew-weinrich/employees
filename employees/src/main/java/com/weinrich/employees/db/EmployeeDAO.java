package com.weinrich.employees.db;

import com.weinrich.employees.api.Employee;

import com.weinrich.employees.db.EmployeeDAOInterface;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class EmployeeDAO extends AbstractDAO<Employee> implements EmployeeDAOInterface {
    public EmployeeDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<Employee> findEmployeeByName(String firstName, String lastName) {
        return Optional.empty();
    }

    public Employee create(Employee employee) {
        return employee;
    }
}