package com.weinrich.employees.resources;

import com.weinrich.employees.api.*;
import com.weinrich.employees.db.*;
import com.weinrich.employees.core.*;

import com.codahale.metrics.annotation.Timed;

import io.dropwizard.hibernate.*;

import java.util.*;
import java.text.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.validation.constraints.*;
import javax.validation.Valid;


@Path("/employee/{id}")
@Produces(MediaType.APPLICATION_JSON)
public class GetEmployeeResource {
    final EmployeeDAOInterface employeeDao;
    
    public GetEmployeeResource(EmployeeDAOInterface employeeDao) {
        this.employeeDao = employeeDao;
    }
    
    
    @GET
    @Timed
    @UnitOfWork
    public EmployeeJson getEmployee(@PathParam("id") int id) {
        Optional<Employee> employeeOptional = this.employeeDao.getEmployeeById(id);
        
        if (!employeeOptional.isPresent()) {
            throw new WebApplicationException("Invalid employee ID", 404);
        }
        else {
            Employee employee = employeeOptional.get();
            EmployeeJson employeeJson = new EmployeeJson(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getTitle().getName(),
                employee.getTitle().getDepartment().getName(),
                EmployeeJson.getDateFormat().format(employee.getStartDate()));
            return employeeJson;
        }
    }
}