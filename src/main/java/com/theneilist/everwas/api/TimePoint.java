package com.theneilist.everwas.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.theneilist.everwas.api.jsonapi.JsonApiBaseEntity;
import com.theneilist.everwas.api.serializers.OffsetDateTimeDeserializer;
import com.theneilist.everwas.api.serializers.OffsetDateTimeSerializer;

import java.time.OffsetDateTime;

public class TimePoint {

    private long id;
    private long categoryId;
    private String name;
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime time;

    public TimePoint() {
    }

    public TimePoint(long categoryId, String name, OffsetDateTime time) {
        this.categoryId = categoryId;
        this.name = name;
        this.time = time;
    }

    public TimePoint(long id, long categoryId, String name, OffsetDateTime time) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.time = time;
    }

    @JsonProperty
    public long getId() {
        return id;
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
