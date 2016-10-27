package com.theneilist.everwas.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.theneilist.everwas.api.jsonapi.JsonApiBaseEntity;

import java.util.List;

public class Timeline {

    private long id;
    private Category category;
    private List<TimePeriod> timePeriods;
    private List<TimePoint> timePoints;

    public Timeline(Category category, List<TimePeriod> timePeriods, List<TimePoint> timePoints) {
        this.id = category.getId();
        this.category = category;
        this.timePeriods = timePeriods;
        this.timePoints = timePoints;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public Category getCategory() {
        return category;
    }

    @JsonProperty
    public List<TimePeriod> getTimePeriods() {
        return timePeriods;
    }

    @JsonProperty
    public List<TimePoint> getTimePoints() {
        return timePoints;
    }
}
