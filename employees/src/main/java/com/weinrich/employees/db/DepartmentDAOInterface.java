package com.weinrich.employees.db;

import com.weinrich.employees.core.Department;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.Optional;

public interface DepartmentDAOInterface {
    Optional<Department> findDepartmentByName(String departmentName);
}