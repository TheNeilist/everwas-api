package com.theneilist.everwas.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.theneilist.everwas.api.jsonapi.JsonApiBaseEntity;

import java.time.OffsetDateTime;

public class TimePeriod extends BaseApi implements JsonApiBaseEntity {

    private static final String TYPE = "timeperiod";
    private long categoryId;
    private String name;
    private OffsetDateTime periodStart;
    private OffsetDateTime periodEnd;

    public TimePeriod() {
    }

    public TimePeriod(long categoryId, String name, OffsetDateTime periodStart, OffsetDateTime periodEnd) {
        this.categoryId = categoryId;
        this.name = name;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
    }

    public TimePeriod(long id, long categoryId, String name, OffsetDateTime periodStart, OffsetDateTime periodEnd) {
        super(id, TYPE);
        this.categoryId = categoryId;
        this.name = name;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
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
    public OffsetDateTime getPeriodStart() {
        return periodStart;
    }

    @JsonProperty
    public OffsetDateTime getPeriodEnd() {
        return periodEnd;
    }
}
