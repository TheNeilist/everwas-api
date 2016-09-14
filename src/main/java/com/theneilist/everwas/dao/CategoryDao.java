package com.theneilist.everwas.dao;

import com.theneilist.everwas.api.Category;
import com.theneilist.everwas.mapper.CategoryMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.customizers.SingleValueResult;

import java.util.Optional;

public interface CategoryDao {

    @SqlUpdate("insert into category (parent_id, name) values (:parentId, :name)")
    @GetGeneratedKeys
    long insert(@Bind("parentId") long parentId, @Bind("name") String name);

    @SqlQuery("select * from category where id = :id")
    @SingleValueResult(Category.class)
    @Mapper(CategoryMapper.class)
    Optional<Category> findById(@Bind("id") long id);

}
