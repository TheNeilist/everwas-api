package com.theneilist.everwas;

import com.google.common.base.Charsets;
import com.theneilist.everwas.dao.CategoryDao;
import com.theneilist.everwas.resource.CategoryResource;
import de.thomaskrille.dropwizard_template_config.TemplateConfigBundle;
import de.thomaskrille.dropwizard_template_config.TemplateConfigBundleConfiguration;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jdbi.OptionalContainerFactory;
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

        bootstrap.addBundle(new TemplateConfigBundle(
                new TemplateConfigBundleConfiguration().charset(Charsets.US_ASCII)
        ));

    }

    @Override
    public void run(EverwasConfiguration config, Environment environment) {

        final DBIFactory factory = new DBIFactory();
        DBI jdbi = factory.build(environment, config.getDataSourceFactory(), "postgresql");
        jdbi.registerContainerFactory(new OptionalContainerFactory());

        final CategoryDao categoryDao = jdbi.onDemand(CategoryDao.class);

        final CategoryResource categoryResource = new CategoryResource(categoryDao);
        environment.jersey().register(categoryResource);

    }
}


