package com.theneilist.everwas.resource;

import com.codahale.metrics.annotation.Timed;
import com.theneilist.everwas.api.Category;
import com.theneilist.everwas.dao.CategoryDao;
import com.theneilist.everwas.dao.TimePeriodDao;
import com.theneilist.everwas.dao.TimePointDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/timeline")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TimelineResource {

    private CategoryDao categoryDao;
    private TimePointDao timePointDao;
    private TimePeriodDao timePeriodDao;

    public TimelineResource(CategoryDao categoryDao, TimePointDao timePointDao, TimePeriodDao timePeriodDao) {
        this.categoryDao = categoryDao;
        this.timePointDao = timePointDao;
        this.timePeriodDao = timePeriodDao;
    }

    @GET
    @Timed
    public Response get() {

        //get all categories
        Optional<List<Category>> categories = categoryDao.findAll();
        if (categories.isPresent()) {

            for (Category category : categories.get()) {


            }

        }

        //for each category

            //get all time periods

            //get all time points

        return Response.ok().build();
    }
}