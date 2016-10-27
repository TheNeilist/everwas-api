package com.theneilist.everwas.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryWrapper {

    private Category category;

    public CategoryWrapper() {
    }

    public CategoryWrapper(Category category) {
        this.category = category;
    }

    @JsonProperty
    public Category getCategory() {
        return category;
    }

}
