package com.theneilist.everwas.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface CategoryDao {

    @SqlUpdate("insert into category (parent_id, name) values (:parentId, :name)")
    @GetGeneratedKeys
    long insert(@Bind("parentId") long parentId, @Bind("name") String name);

}
