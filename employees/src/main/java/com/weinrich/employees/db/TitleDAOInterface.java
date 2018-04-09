package com.weinrich.employees.db;

import com.weinrich.employees.core.Title;

import java.util.Optional;

public interface TitleDAOInterface {
    Optional<Title> findTitleByName(String titleName, String departmentName);
}