package com.weinrich.employees.resources;

import com.weinrich.employees.api.*;
import com.weinrich.employees.db.*;
import com.weinrich.employees.core.*;

import com.codahale.metrics.annotation.Timed;

import java.util.*;
import java.text.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.validation.constraints.*;
import javax.validation.Valid;


@Path("/addEmployee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AddEmployeeResource {
    final EmployeeDAOInterface employeeDao;
    final TitleDAOInterface titleDao;
    final DepartmentDAOInterface departmentDao;
    
    public AddEmployeeResource(
        EmployeeDAOInterface employeeDao,
        TitleDAOInterface titleDao,
        DepartmentDAOInterface departmentDao)
    {
        this.employeeDao = employeeDao;
        this.departmentDao = departmentDao;
        this.titleDao = titleDao;
    }
    
    
    @POST
    @Timed
    public Employee addEmployee(@NotNull @Valid Employee employee) {
        try {
            // validate start date
            // realistically there should be additional checks here (e.g. you can't have a starting date in 1872)
            Date date = Employee.getDateFormat().parse(employee.getStartDate());
        }
        catch (Exception e) {
            throw new WebApplicationException("Invalid start date: " + employee.getStartDate(), 400);
        }
        
        // check department and title
        Optional<Department> department = departmentDao.findDepartmentByName(employee.getDepartment());
        if (!department.isPresent())
            throw new WebApplicationException("Invalid department name: " + employee.getDepartment(), 400);
        
        Optional<Title> title = titleDao.findTitleByName(employee.getTitle(), employee.getDepartment());
        if (!title.isPresent())
            throw new WebApplicationException("Invalid title name: " + employee.getTitle(), 400);
        
        // return back the employee with a newly-created ID
        return employeeDao.createEmployee(employee);
    }
}