package com.theneilist.everwas;

import java.time.ZoneId;

public class DefaultTimeZone {

    private static final String ZONE_ID = "America/Denver";

    public static ZoneId getZoneId() {
        return ZoneId.of(ZONE_ID);
    }

}
