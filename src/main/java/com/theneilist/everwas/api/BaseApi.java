package com.theneilist.everwas.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.theneilist.everwas.api.jsonapi.JsonApiBaseEntity;

public abstract class BaseApi {

    private long id;

    private String type;

    public BaseApi() {
    }

    public BaseApi(String type) {
        this.type = type;
    }

    public BaseApi(long id, String type) {
        this.id = id;
        this.type = type;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty
    public String getType() {
        return type;
    }
}
