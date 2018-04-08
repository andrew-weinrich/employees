package com.weinrich.employees.resources;

import com.weinrich.employees.api.*;
import com.weinrich.employees.db.*;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.List;



@Path("/getEmployeesInDepartment/{department}")
@Produces(MediaType.APPLICATION_JSON)
public class GetDepartmentResource {
    
    private final DepartmentDAOInterface departmentDAO;
    
    private Department department;
    
    public GetDepartmentResource(DepartmentDAOInterface departmentDAO) {
        this.departmentDAO = departmentDAO;
        this.department = new Department(1, "Foo");
    }
    
    @GET
    @Timed
    public List<Employee> getEmployeesInDepartment(@PathParam("user") String department) {
        //return this.employeeDao.findDepartmentEmployees(department);
        return this.department.getEmployees();
    }
}