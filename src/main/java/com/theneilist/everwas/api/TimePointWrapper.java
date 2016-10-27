package com.theneilist.everwas.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimePointWrapper {

    private TimePoint timepoint;

    public TimePointWrapper() {
    }

    public TimePointWrapper(TimePoint timepoint) {
        this.timepoint = timepoint;
    }

    @JsonProperty
    public TimePoint getTimepoint() {
        return timepoint;
    }
}
