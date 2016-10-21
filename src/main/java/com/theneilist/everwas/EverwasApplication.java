package com.theneilist.everwas;

import com.google.common.base.Charsets;
import com.theneilist.everwas.dao.CategoryDao;
import com.theneilist.everwas.dao.TimePeriodDao;
import com.theneilist.everwas.dao.TimePointDao;
import com.theneilist.everwas.resource.CategoryResource;
import com.theneilist.everwas.resource.TimelineResource;
import com.theneilist.everwas.resource.TimePeriodResource;
import com.theneilist.everwas.resource.TimePointResource;
import de.thomaskrille.dropwizard_template_config.TemplateConfigBundle;
import de.thomaskrille.dropwizard_template_config.TemplateConfigBundleConfiguration;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jdbi.OptionalContainerFactory;
import io.dropwizard.jdbi.args.OffsetDateTimeMapper;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.skife.jdbi.v2.DBI;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

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

        FilterRegistration.Dynamic filter = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,PUT,POST,DELETE,OPTIONS");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        filter.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
        filter.setInitParameter("allowedHeaders", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
        filter.setInitParameter("allowCredentials", "true");

        final DBIFactory factory = new DBIFactory();
        DBI jdbi = factory.build(environment, config.getDataSourceFactory(), "postgresql");
        jdbi.registerContainerFactory(new OptionalContainerFactory());
        jdbi.registerColumnMapper(new OffsetDateTimeMapper());

        final CategoryDao categoryDao = jdbi.onDemand(CategoryDao.class);
        final TimePointDao timePointDao = jdbi.onDemand(TimePointDao.class);
        final TimePeriodDao timePeriodDao = jdbi.onDemand(TimePeriodDao.class);

        final CategoryResource categoryResource = new CategoryResource(categoryDao);
        environment.jersey().register(categoryResource);

        final TimePointResource timePointResource = new TimePointResource(timePointDao);
        environment.jersey().register(timePointResource);

        final TimePeriodResource timePeriodResource = new TimePeriodResource(timePeriodDao);
        environment.jersey().register(timePeriodResource);

        final TimelineResource timelineResource = new TimelineResource(categoryDao, timePointDao, timePeriodDao);
        environment.jersey().register(timelineResource);

    }
}


