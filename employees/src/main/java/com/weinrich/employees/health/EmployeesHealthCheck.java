package com.weinrich.employees.health;

import com.codahale.metrics.health.HealthCheck;

public class EmployeesHealthCheck extends HealthCheck {
    public EmployeesHealthCheck() {
        //
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}