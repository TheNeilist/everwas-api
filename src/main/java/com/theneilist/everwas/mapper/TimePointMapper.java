package com.theneilist.everwas.mapper;

import com.theneilist.everwas.DefaultTimeZone;
import com.theneilist.everwas.api.TimePoint;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class TimePointMapper implements ResultSetMapper<TimePoint> {

    public TimePoint map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new TimePoint(
                r.getLong("id"),
                r.getLong("category_id"),
                r.getString("name"),
                //TODO: handle time zones
                OffsetDateTime.ofInstant(r.getTimestamp("time_point").toInstant(), DefaultTimeZone.getZoneId())
        );
    }

}
