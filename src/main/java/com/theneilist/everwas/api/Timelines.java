package com.theneilist.everwas.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Timelines {

    private List<Timeline> timelines;

    public Timelines() {
    }

    public Timelines(List<Timeline> timelines) {
        this.timelines = timelines;
    }

    @JsonProperty
    public List<Timeline> getTimelines() {
        return timelines;
    }
}
