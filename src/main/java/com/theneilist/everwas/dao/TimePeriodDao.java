package com.theneilist.everwas.dao;

import com.theneilist.everwas.api.TimePeriod;
import com.theneilist.everwas.mapper.TimePeriodMapper;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.customizers.SingleValueResult;

import java.util.Optional;

public interface TimePeriodDao {

    @SqlUpdate("insert into time_period (category_id, name, period_start, period_end) " +
            "values (:timePeriod.categoryId, :timePeriod.name, :timePeriod.periodStart, :timePeriod.periodEnd)")
    @GetGeneratedKeys
    long insert(@BindBean("timePeriod") TimePeriod timePeriod);

    @SqlQuery("select * from time_period where id = :id")
    @SingleValueResult(TimePeriod.class)
    @Mapper(TimePeriodMapper.class)
    Optional<TimePeriod> findById(@Bind("id") long id);

    @SqlUpdate("delete from time_period where id = :id")
    void delete(@Bind("id") long id);

}
