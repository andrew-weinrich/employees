package com.weinrich.employees;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;

import com.weinrich.employees.resources.*;
import com.weinrich.employees.health.*;
import com.weinrich.employees.api.*;
import com.weinrich.employees.core.*;
import com.weinrich.employees.db.*;

public class EmployeesApplication extends Application<EmployeesConfiguration> {

    public static void main(final String[] args) throws Exception {
        new EmployeesApplication().run(args);
    }

    @Override
    public String getName() {
        return "Employees";
    }
    
    private final HibernateBundle<EmployeesConfiguration> hibernateBundle =
        new HibernateBundle<EmployeesConfiguration>(Employee.class, Title.class, Department.class) {
            @Override
            public DataSourceFactory getDataSourceFactory(EmployeesConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        };;
    

    @Override
    public void initialize(final Bootstrap<EmployeesConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(final EmployeesConfiguration configuration,
                    final Environment environment)
    {
        final EmployeeDAOInterface employeeDao = new EmployeeDAO(hibernateBundle.getSessionFactory());
        final DepartmentDAOInterface departmentDao = new DepartmentDAO(hibernateBundle.getSessionFactory());
        final TitleDAOInterface titleDao = new TitleDAO(hibernateBundle.getSessionFactory());
                        
        final AddEmployeeResource addEmployeeResource = new AddEmployeeResource(employeeDao, titleDao, departmentDao);
        environment.jersey().register(addEmployeeResource);
        
        final GetEmployeeResource getEmployeeResource = new GetEmployeeResource(employeeDao);
        environment.jersey().register(getEmployeeResource);
        
        final GetDepartmentResource getDepartmentResource = new GetDepartmentResource(departmentDao, employeeDao);
        environment.jersey().register(getDepartmentResource);

        final EmployeesHealthCheck healthCheck = new EmployeesHealthCheck();
        environment.healthChecks().register("employees", healthCheck);
        environment.jersey().register(healthCheck);
    }

}
