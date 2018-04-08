package com.weinrich.employees.db;

import com.weinrich.employees.api.*;

import com.weinrich.employees.db.TitleDAOInterface;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.Optional;

public class TitleDAO extends AbstractDAO<Employee> implements TitleDAOInterface {
    public TitleDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<Title> findTitleByName(String titleName, String departmentName) {
        return Optional.empty();
    }
}