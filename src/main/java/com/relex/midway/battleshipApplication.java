package com.relex.midway;

import com.relex.midway.resources.NextTurnResource;
import com.relex.midway.resources.OwnGridResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class battleshipApplication extends Application<battleshipConfiguration> {

    public static void main(final String[] args) throws Exception {
        new battleshipApplication().run(args);
    }

    @Override
    public String getName() {
        return "battleship";
    }

    @Override
    public void initialize(final Bootstrap<battleshipConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final battleshipConfiguration configuration,
                    final Environment environment) {
        final OwnGridResource resource = new OwnGridResource();
        final NextTurnResource nextResource = new NextTurnResource();
        environment.jersey().register(resource);
        environment.jersey().register(nextResource);
    }
}
