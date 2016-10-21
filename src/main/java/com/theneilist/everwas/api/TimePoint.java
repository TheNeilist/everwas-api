package com.theneilist.everwas.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.theneilist.everwas.api.jsonapi.JsonApiBaseEntity;

import java.time.OffsetDateTime;

public class TimePoint extends BaseApi implements JsonApiBaseEntity {

    private static final String TYPE = "timepoint";
    private long categoryId;
    private String name;
    private OffsetDateTime time;

    public TimePoint() {
    }

    public TimePoint(long categoryId, String name, OffsetDateTime time) {
        this.categoryId = categoryId;
        this.name = name;
        this.time = time;
    }

    public TimePoint(long id, long categoryId, String name, OffsetDateTime time) {
        super(id, TYPE);
        this.categoryId = categoryId;
        this.name = name;
        this.time = time;
    }

    @JsonProperty
    public long getCategoryId() {
        return categoryId;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public OffsetDateTime getTime() {
        return time;
    }
}
