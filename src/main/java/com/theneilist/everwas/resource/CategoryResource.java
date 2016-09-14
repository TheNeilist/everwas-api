package com.theneilist.everwas.resource;

import com.codahale.metrics.annotation.Timed;
import com.theneilist.everwas.api.Category;
import com.theneilist.everwas.dao.CategoryDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {

    private CategoryDao categoryDao;

    public CategoryResource(final CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @POST
    @Timed
    public Response createCategory(final Category category) {
        long categoryId = this.categoryDao.insert(category.getParentId(), category.getName());
        return Response
                .status(Response.Status.CREATED)
                .entity(new Category(categoryId, category.getParentId(), category.getName()))
                .build();
    }

    @GET
    @Path("{id}")
    @Timed
    public Response getCategory(@PathParam("id") Long id) {
        final Optional<Category> category = categoryDao.findById(id);
        return category.isPresent() ?
                Response.ok().entity(category.get()).build() :
                Response.status(Response.Status.NOT_FOUND).build();
    }
}