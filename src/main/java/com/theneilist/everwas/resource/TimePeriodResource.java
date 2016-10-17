package com.theneilist.everwas.resource;

import com.codahale.metrics.annotation.Timed;
import com.theneilist.everwas.DefaultTimeZone;
import com.theneilist.everwas.api.TimePeriod;
import com.theneilist.everwas.api.TimePoint;
import com.theneilist.everwas.dao.TimePeriodDao;
import com.theneilist.everwas.dao.TimePointDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.OffsetDateTime;
import java.util.Optional;

@Path("/timeperiod")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TimePeriodResource {

    private TimePeriodDao timePeriodDao;

    public TimePeriodResource(TimePeriodDao timePeriodDao) {
        this.timePeriodDao = timePeriodDao;
    }

    @POST
    @Timed
    public Response create(final TimePeriod timePeriod) {
        //TODO: validate category id
        long timePointId = this.timePeriodDao.insert(timePeriod);
        OffsetDateTime periodStart = OffsetDateTime.from(timePeriod.getPeriodStart().atZoneSameInstant(DefaultTimeZone.getZoneId()));
        OffsetDateTime periodEnd= OffsetDateTime.from(timePeriod.getPeriodEnd().atZoneSameInstant(DefaultTimeZone.getZoneId()));
        return Response
                .status(Response.Status.CREATED)
                .entity(new TimePeriod(timePointId, timePeriod.getCategoryId(), timePeriod.getName(), periodStart, periodEnd))
                .build();
    }

    @GET
    @Path("{id}")
    @Timed
    public Response get(@PathParam("id") Long id) {
        final Optional<TimePeriod> timePeriod = timePeriodDao.findById(id);
        return timePeriod.isPresent() ?
                Response.ok(timePeriod.get()).build() :
                Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Timed
    public Response deleteAll() {
        timePeriodDao.deleteAll();
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("{id}")
    @Timed
    public Response delete(@PathParam("id") Long id) {
        final Optional<TimePeriod> timePeriod = timePeriodDao.findById(id);
        if (!timePeriod.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        timePeriodDao.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}