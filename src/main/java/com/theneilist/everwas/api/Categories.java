package com.theneilist.everwas.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Categories {

    private List<Category> categories;

    public Categories(List<Category> categories) {

        this.categories = categories;
    }

    @JsonProperty
    public List<Category> getCategories() {
        return categories;
    }
}
