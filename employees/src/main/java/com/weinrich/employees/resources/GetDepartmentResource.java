package com.weinrich.employees.resources;

import com.weinrich.employees.api.*;
import com.weinrich.employees.db.*;

import com.codahale.metrics.annotation.Timed;

import io.dropwizard.hibernate.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.List;


@Path("/getEmployeesInDepartment/{department}")
@Produces(MediaType.APPLICATION_JSON)
public class GetDepartmentResource {
    private final DepartmentDAOInterface departmentDAO;
    
    public GetDepartmentResource(DepartmentDAOInterface departmentDAO) {
        this.departmentDAO = departmentDAO;
    }
    
    @GET
    @Timed
    @UnitOfWork
    public List<Employee> getEmployeesInDepartment(@PathParam("department") String departmentName) {
        Optional<Department> department = this.departmentDAO.findDepartmentByName(departmentName);
        
        if (!department.isPresent())
            throw new WebApplicationException("Invalid department", 404);
        else
            return department.get().getEmployees();
    }
}