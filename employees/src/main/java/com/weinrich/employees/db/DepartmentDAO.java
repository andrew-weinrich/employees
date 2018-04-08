package com.weinrich.employees.db;

import com.weinrich.employees.api.Department;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.Optional;

public class DepartmentDAO extends AbstractDAO<Department> implements DepartmentDAOInterface {
    
    public DepartmentDAO(SessionFactory factory) {
        super(factory);
    }
    
    public Optional<Department> findDepartmentByName(String departmentName) {
        return Optional.empty();
    }
}