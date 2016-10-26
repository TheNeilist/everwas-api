package com.theneilist.everwas.api;

public class CategoryPost {
    private Category category;

    public CategoryPost() {
    }

    public CategoryPost(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
