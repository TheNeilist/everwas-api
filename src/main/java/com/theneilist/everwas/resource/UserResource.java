package com.theneilist.everwas.resource;

import com.codahale.metrics.annotation.Timed;
import com.theneilist.everwas.api.AuthenticationCredentials;
import com.theneilist.everwas.api.User;
import com.theneilist.everwas.dao.UserDao;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private UserDao userDao;

    public UserResource(final UserDao userDao) {
        this.userDao = userDao;
    }

    @POST
    @Timed
    public Response authenticate(final AuthenticationCredentials authenticationCredentials) {
        final Optional<User> user = userDao.findByCredentials(authenticationCredentials);
        return user.isPresent() ?
                Response.ok().entity(user.get()).build() :
                Response.status(Response.Status.NOT_FOUND).build();
    }

}