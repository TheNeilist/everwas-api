package com.theneilist.everwas;

import com.theneilist.everwas.dao.CategoryDao;
import com.theneilist.everwas.resources.CategoryResource;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

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

        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor()
                )
        );

    }

    @Override
    public void run(EverwasConfiguration config, Environment environment) {

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, config.getDataSourceFactory(), "postgresql");

        final CategoryDao categoryDao = jdbi.onDemand(CategoryDao.class);

        final CategoryResource categoryResource = new CategoryResource(categoryDao);
        environment.jersey().register(categoryResource);

    }
}


