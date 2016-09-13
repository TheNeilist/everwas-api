package com.theneilist.everwas.resources;

import com.codahale.metrics.annotation.Timed;
import com.theneilist.everwas.api.Category;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryResource {

    public CategoryResource() {
    }

    @POST
    @Timed
    public Category createCategory(final Category category) {
        return category;
    }

    @GET
    @Timed
    public List<Category> listCategories() {
        return Arrays.asList(new Category(1, 2, "test"));
    }
}