package com.theneilist.everwas.resource;

import com.codahale.metrics.annotation.Timed;
import com.theneilist.everwas.DefaultTimeZone;
import com.theneilist.everwas.api.TimePoint;
import com.theneilist.everwas.dao.TimePointDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.OffsetDateTime;
import java.util.Optional;

@Path("/timepoint")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TimePointResource {

    private TimePointDao timePointDao;

    public TimePointResource(final TimePointDao timePointDao) {
        this.timePointDao = timePointDao;
    }

    @POST
    @Timed
    public Response create(final TimePoint timePoint) {
        //TODO: validate category id
        long timePointId = this.timePointDao.insert(timePoint);
        OffsetDateTime time = OffsetDateTime.from(timePoint.getTime().atZoneSameInstant(DefaultTimeZone.getZoneId()));
        return Response
                .status(Response.Status.CREATED)
                .entity(new TimePoint(timePointId, timePoint.getCategoryId(), timePoint.getName(), time))
                .build();
    }

    @GET
    @Path("{id}")
    @Timed
    public Response get(@PathParam("id") Long id) {
        final Optional<TimePoint> timePoint;
        try {
            timePoint = timePointDao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
        return timePoint.isPresent() ?
                Response.ok(timePoint.get()).build() :
                Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Timed
    public Response deleteAll() {
        timePointDao.deleteAll();
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("{id}")
    @Timed
    public Response delete(@PathParam("id") Long id) {
        final Optional<TimePoint> timePoint = timePointDao.findById(id);
        if (!timePoint.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        timePointDao.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}