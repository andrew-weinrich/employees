package com.weinrich.employees;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.weinrich.employees.resources.*;
import com.weinrich.employees.health.*;

public class EmployeesApplication extends Application<EmployeesConfiguration> {

    public static void main(final String[] args) throws Exception {
        new EmployeesApplication().run(args);
    }

    @Override
    public String getName() {
        return "Employees";
    }

    @Override
    public void initialize(final Bootstrap<EmployeesConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final EmployeesConfiguration configuration,
                    final Environment environment) {
        final AddEmployeeResource addEmployeeResource = new AddEmployeeResource();
        environment.jersey().register(addEmployeeResource);
        
        final GetDepartmentResource getDepartmentResource = new GetDepartmentResource();
        environment.jersey().register(getDepartmentResource);

        final EmployeesHealthCheck healthCheck = new EmployeesHealthCheck();
        environment.healthChecks().register("employees", healthCheck);
        environment.jersey().register(healthCheck);
    }

}
