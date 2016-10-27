package com.theneilist.everwas.resource;

import com.codahale.metrics.annotation.Timed;
import com.theneilist.everwas.api.*;
import com.theneilist.everwas.dao.CategoryDao;
import com.theneilist.everwas.dao.TimePeriodDao;
import com.theneilist.everwas.dao.TimePointDao;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/timelines")
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

        final List<Category> categories = categoryDao.findAll();
        List<Timeline> timelineList = new ArrayList<>();
        for (final Category category : categories) {
            final List<TimePoint> timePoints = timePointDao.findByCategoryId(category.getId());
            final List<TimePeriod> timePeriods = timePeriodDao.findByCategoryId(category.getId());
            final Timeline timeline = new Timeline(
                    category,
                    timePeriods,
                    timePoints);
            timelineList.add(timeline);
        }

        final Timelines timelines = new Timelines(timelineList);
        return Response.ok().entity(timelines).build();

    }
}