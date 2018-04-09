package com.weinrich.employees.db;

import com.weinrich.employees.core.Employee;

import com.weinrich.employees.db.EmployeeDAOInterface;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.*;

import java.util.*;


public class EmployeeDAO extends AbstractDAO<Employee> implements EmployeeDAOInterface {
    public EmployeeDAO(SessionFactory factory) {
        super(factory);
    }
    
    public List<Employee> findEmployeesByName(String lastName, String firstName) {
        return new ArrayList<Employee>();
    }

    public Employee createEmployee(Employee employee) {
        return persist(employee);
    }

    public Optional<Employee> getEmployeeById(int id) {
        Query query = namedQuery("com.weinrich.employees.core.Employee.getEmployeeById");  
        query.setInteger("id", id);  
        
        Employee employee = (Employee)(query.uniqueResult());
        
        return Optional.ofNullable(employee);
    }


}