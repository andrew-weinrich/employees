package com.weinrich.employees.db;

import com.weinrich.employees.api.Employee;
import com.weinrich.employees.api.Department;

import java.util.Optional;

public interface EmployeeDAOInterface {
    Optional<Employee> findEmployeeByName(String firstName, String lastName);

    Employee create(Employee employee);
}