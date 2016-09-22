package com.theneilist.everwas.mapper;

import com.theneilist.everwas.DefaultTimeZone;
import com.theneilist.everwas.api.TimePeriod;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;

public class TimePeriodMapper implements ResultSetMapper<TimePeriod> {

    public TimePeriod map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new TimePeriod(
                r.getLong("id"),
                r.getLong("category_id"),
                r.getString("name"),
                OffsetDateTime.ofInstant(r.getTimestamp("period_start").toInstant(), DefaultTimeZone.getZoneId()),
                OffsetDateTime.ofInstant(r.getTimestamp("period_end").toInstant(), DefaultTimeZone.getZoneId())
        );
    }

}
