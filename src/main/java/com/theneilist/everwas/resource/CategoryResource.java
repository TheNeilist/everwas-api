package com.theneilist.everwas.resource;

import com.codahale.metrics.annotation.Timed;
import com.theneilist.everwas.api.Categories;
import com.theneilist.everwas.api.Category;
import com.theneilist.everwas.api.CategoryWrapper;
import com.theneilist.everwas.dao.CategoryDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {

    private CategoryDao categoryDao;

    public CategoryResource(final CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @POST
    @Path("categories")
    @Timed
    public Response create(final CategoryWrapper categoryWrapper) {
        long categoryId = this.categoryDao.insert(categoryWrapper.getCategory());
        Category category = new Category(categoryId, categoryWrapper.getCategory().getParentId(), categoryWrapper.getCategory().getName());
        return Response
                .status(Response.Status.CREATED)
                .entity(new CategoryWrapper(category))
                .build();
    }

    @GET
    @Path("category/{id}")
    @Timed
    public Response get(@PathParam("id") Long id) {
        final Optional<Category> category = categoryDao.findById(id);
        return category.isPresent() ?
                Response.ok().entity(category.get()).build() :
                Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("categories")
    @Timed
    public Response findAll() {
        List<Category> categories = categoryDao.findAll();
        return Response.ok().entity(new Categories(categories)).build();
    }

    @DELETE
    @Path("categories")
    @Timed
    public Response deleteAll() {
        //todo: delete all points and periods first
        categoryDao.deleteAll();
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("category/{id}")
    @Timed
    public Response delete(@PathParam("id") Long id) {
        final Optional<Category> category = categoryDao.findById(id);
        if (!category.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        categoryDao.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}