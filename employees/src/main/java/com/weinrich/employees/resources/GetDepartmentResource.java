package com.weinrich.employees.resources;

import com.weinrich.employees.api.*;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;



@Path("/getEmployeesInDepartment/{department}")
@Produces(MediaType.APPLICATION_JSON)
public class GetDepartmentResource {
    
    private Department department;
    
    public GetDepartmentResource() {
        this.department = new Department(1, "Foo");
    }
    
    @GET
    @Timed
    public Department getEmployeesInDepartment(@PathParam("user") String department) {
        return this.department;
    }
}