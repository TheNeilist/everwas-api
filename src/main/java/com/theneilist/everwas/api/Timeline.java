package com.theneilist.everwas.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Timeline extends BaseApi {

    private List<CategoryTimeline> categoryTimelines;

    public Timeline() {
    }

    public Timeline(List<CategoryTimeline> categoryTimelines) {
        this.categoryTimelines = categoryTimelines;
    }

    @JsonProperty
    public List<CategoryTimeline> getCategoryTimelines() {
        return categoryTimelines;
    }
}
