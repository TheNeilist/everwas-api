package com.theneilist.everwas.dao;

import com.theneilist.everwas.api.Category;
import com.theneilist.everwas.mapper.CategoryMapper;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.customizers.SingleValueResult;

import java.util.List;
import java.util.Optional;

public interface CategoryDao {

    @SqlUpdate("insert into category (parent_id, name) values (:category.parentId, :category.name)")
    @GetGeneratedKeys
    long insert(@BindBean("category") Category category);

    @SqlQuery("select * from category where id = :id")
    @SingleValueResult(Category.class)
    @Mapper(CategoryMapper.class)
    Optional<Category> findById(@Bind("id") long id);

    @SqlUpdate("delete from category where id = :id")
    void delete(@Bind("id") long id);

    @SqlQuery("select * from category order by name")
    @Mapper(CategoryMapper.class)
    List<Category> findAll();

    @SqlUpdate("delete from category")
    void deleteAll();

}
