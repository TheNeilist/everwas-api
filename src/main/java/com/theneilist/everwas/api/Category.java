package com.theneilist.everwas.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.theneilist.everwas.api.jsonapi.JsonApiBaseEntity;

public class Category extends BaseApi implements JsonApiBaseEntity {

    private static final String TYPE = "category";
    private long parentId;
    private String name;

    public Category() {
        super(TYPE);
    }

    public Category(String name) {
        super(TYPE);
        this.name = name;
    }

    public Category(long parentId, String name) {
        super(TYPE);
        this.parentId = parentId;
        this.name = name;
    }

    public Category(long id, long parentId, String name) {
        super(id, TYPE);
        this.parentId = parentId;
        this.name = name;
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
