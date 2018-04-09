package com.weinrich.employees.db;

import com.weinrich.employees.api.Department;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.*;

import java.util.Optional;

public class DepartmentDAO extends AbstractDAO<Department> implements DepartmentDAOInterface {
    
    public DepartmentDAO(SessionFactory factory) {
        super(factory);
    }
    
    public Optional<Department> findDepartmentByName(String departmentName) {
        Query query = namedQuery("com.weinrich.employees.api.Department.findDepartmentByName");  
        query.setString("name", departmentName);  
        
        Department department = (Department)(query.uniqueResult());
        
        return Optional.ofNullable(department);
    }
}