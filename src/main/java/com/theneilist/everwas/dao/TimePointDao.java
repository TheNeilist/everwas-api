package com.theneilist.everwas.dao;

import com.theneilist.everwas.api.TimePoint;
import com.theneilist.everwas.mapper.TimePointMapper;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.customizers.SingleValueResult;

import java.util.List;
import java.util.Optional;

public interface TimePointDao {

    @SqlUpdate("insert into time_point (category_id, name, time_point) " +
            "values (:timePoint.categoryId, :timePoint.name, :timePoint.time)")
    @GetGeneratedKeys
    long insert(@BindBean("timePoint") TimePoint timePoint);

    @SqlQuery("select * from time_point where id = :id")
    @SingleValueResult(TimePoint.class)
    @Mapper(TimePointMapper.class)
    Optional<TimePoint> findById(@Bind("id") long id);

    @SqlQuery("select * from time_point where category_id = :categoryId")
    @Mapper(TimePointMapper.class)
    List<TimePoint> findByCategoryId(@Bind("categoryId") long categoryId);

    @SqlUpdate("delete from time_point where id = :id")
    void delete(@Bind("id") long id);

    @SqlUpdate("delete from time_point")
    void deleteAll();

}
