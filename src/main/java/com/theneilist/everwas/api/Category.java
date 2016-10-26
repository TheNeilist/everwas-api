package com.theneilist.everwas.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {

    private long id;
    private long parentId;
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(long parentId, String name) {
        this.parentId = parentId;
        this.name = name;
    }

    public Category(long id, long parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
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
    public String getName() {
        return name;
    }

}
