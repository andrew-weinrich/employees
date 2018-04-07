package com.weinrich.employees.health;

import com.codahale.metrics.health.HealthCheck;

public class EmployeesHealthCheck extends HealthCheck {
    public EmployeesHealthCheck() {
        //
    }

    @Override
    protected Result check() throws Exception {
        // check db connection
        //if (!db.connectionIsValid) {
        //    return Result.unhealthy("template doesn't include a name");
        //}
        return Result.healthy();
    }
}