package com.weinrich.employees.resources;

import com.weinrich.employees.api.*;
import com.weinrich.employees.core.*;
import com.weinrich.employees.db.*;

import com.codahale.metrics.annotation.Timed;

import io.dropwizard.hibernate.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.*;
import java.util.stream.Collectors;

@Path("/getEmployeesInDepartment/{department}")
@Produces(MediaType.APPLICATION_JSON)
public class GetDepartmentResource {
    private final DepartmentDAOInterface departmentDao;
    private final EmployeeDAOInterface employeeDao;
    
    public GetDepartmentResource(DepartmentDAOInterface departmentDao, EmployeeDAOInterface employeeDao) {
        this.departmentDao = departmentDao;
        this.employeeDao = employeeDao;
    }
    
    @GET
    @Timed
    @UnitOfWork
    public List<EmployeeJson> getEmployeesInDepartment(@PathParam("department") String departmentName) {
        Optional<Department> department = departmentDao.findDepartmentByName(departmentName);
        if (!department.isPresent())
            throw new WebApplicationException("Invalid department name: " + departmentName, 404);
        
        List<Employee> employees = this.employeeDao.findEmployeesByDepartmentName(departmentName);
        
        // convert domain objects to view objects
        List<EmployeeJson> jsonList = employees.stream().map(e -> new EmployeeJson(
                e.getId(),
                e.getFirstName(),
                e.getLastName(),
                e.getTitle().getName(),
                e.getTitle().getDepartment().getName(),
                EmployeeJson.getDateFormat().format(e.getStartDate())))
            .collect(Collectors.toList());
        
        return jsonList;
    }
}