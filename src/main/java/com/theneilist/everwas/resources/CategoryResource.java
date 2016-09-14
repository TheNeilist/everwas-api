package com.theneilist.everwas.resources;

import com.codahale.metrics.annotation.Timed;
import com.theneilist.everwas.api.Category;
import com.theneilist.everwas.dao.CategoryDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryResource {

    private CategoryDao categoryDao;

    public CategoryResource(final CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @POST
    @Timed
    public Category createCategory(final Category category) {
        long categoryId = this.categoryDao.insert(category.getParentId(), category.getName());
        return new Category(categoryId, category.getParentId(), category.getName());
    }

    @GET
    @Timed
    public List<Category> listCategories() {
        return Arrays.asList(new Category(3l, 4l, "asdf"));
    }
}