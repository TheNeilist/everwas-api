package com.theneilist.everwas.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimePeriodWrapper {

    private TimePeriod timeperiod;

    public TimePeriodWrapper() {
    }

    public TimePeriodWrapper(TimePeriod timeperiod) {
        this.timeperiod = timeperiod;
    }

    @JsonProperty
    public TimePeriod getTimeperiod() {
        return timeperiod;
    }

}
