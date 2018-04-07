package employees;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class employees-serviceApplication extends Application<employees-serviceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new employees-serviceApplication().run(args);
    }

    @Override
    public String getName() {
        return "employees-service";
    }

    @Override
    public void initialize(final Bootstrap<employees-serviceConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final employees-serviceConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
