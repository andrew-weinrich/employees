package com.weinrich.employees.db;

import com.weinrich.employees.core.*;

import com.weinrich.employees.db.TitleDAOInterface;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.*;

import java.util.Optional;

public class TitleDAO extends AbstractDAO<Employee> implements TitleDAOInterface {
    public TitleDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<Title> findTitleByName(String titleName, String departmentName) {
        Query query = namedQuery("com.weinrich.employees.core.Title.getTitleByNameAndDepartment");  
        query.setString("titleName", titleName);  
        query.setString("departmentName", departmentName);  
        
        Title title = (Title)(query.uniqueResult());
        
        return Optional.ofNullable(title);
    }
}