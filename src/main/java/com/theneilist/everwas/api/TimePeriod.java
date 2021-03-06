package com.theneilist.everwas.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.theneilist.everwas.api.serializers.OffsetDateTimeDeserializer;
import com.theneilist.everwas.api.serializers.OffsetDateTimeSerializer;

import java.time.OffsetDateTime;

public class TimePeriod {

    private long id;
    private long categoryId;
    private String name;
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime periodStart;
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
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
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
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
    public OffsetDateTime getPeriodStart() {
        return periodStart;
    }

    @JsonProperty
    public OffsetDateTime getPeriodEnd() {
        return periodEnd;
    }
}
