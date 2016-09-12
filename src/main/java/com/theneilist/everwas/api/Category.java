package com.theneilist.everwas.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {

    private long id;
    private long parentId;
    private String title;

    public Category() {
    }

    public Category(long id, long parentId, String title) {
        this.id = id;
        this.parentId = parentId;
        this.title = title;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public long getParentId() {
        return parentId;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }
}
