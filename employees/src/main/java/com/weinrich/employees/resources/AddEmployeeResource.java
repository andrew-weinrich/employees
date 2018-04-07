package com.weinrich.employees.resources;

import com.weinrich.employees.api.*;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import javax.validation.constraints.*;
import javax.validation.Valid;


@Path("/addEmployee")
@Consumes(MediaType.APPLICATION_JSON)
public class AddEmployeeResource {
    public AddEmployeeResource() {
        
    }
    
    @POST
    @Timed
    public Employee addEmployee(@NotNull @Valid Employee employee) {
        return employee;
    }
}