package com.weinrich.employees.db;

import com.weinrich.employees.api.Employee;
import com.weinrich.employees.api.Department;

import java.util.Optional;
import java.util.List;


public interface EmployeeDAOInterface {
    List<Employee> findEmployeesByName(String lastName, String firstName);

    Employee createEmployee(Employee employee);
}