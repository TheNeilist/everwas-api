package com.theneilist.everwas;

import com.theneilist.everwas.resources.CategoryResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class EverwasApplication extends Application<EverwasConfiguration> {

    public static void main(String[] args) throws Exception {
        new EverwasApplication().run(args);
    }

    @Override
    public String getName() {
        return "everwas-api";
    }

    @Override
    public void initialize(Bootstrap<EverwasConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(EverwasConfiguration everwasConfiguration,
                    Environment environment) {
        final CategoryResource categoryResource = new CategoryResource();
        environment.jersey().register(categoryResource);
    }
}


