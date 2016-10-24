package com.theneilist.everwas.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.theneilist.everwas.api.jsonapi.JsonApiBaseEntity;

import java.util.List;

public class CategoryTimeline  extends BaseApi implements JsonApiBaseEntity {

    private static final String TYPE = "timeline";
    private Category category;
    private List<TimePeriod> timePeriods;
    private List<TimePoint> timePoints;

    public CategoryTimeline() {
        super(TYPE);
    }

    public CategoryTimeline(Category category, List<TimePeriod> timePeriods, List<TimePoint> timePoints) {
        super(category.getId(), TYPE);
        this.category = category;
        this.timePeriods = timePeriods;
        this.timePoints = timePoints;
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
