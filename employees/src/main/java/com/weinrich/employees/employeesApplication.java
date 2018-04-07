package com.weinrich.employees;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class employeesApplication extends Application<employeesConfiguration> {

    public static void main(final String[] args) throws Exception {
        new employeesApplication().run(args);
    }

    @Override
    public String getName() {
        return "employees";
    }

    @Override
    public void initialize(final Bootstrap<employeesConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final employeesConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
