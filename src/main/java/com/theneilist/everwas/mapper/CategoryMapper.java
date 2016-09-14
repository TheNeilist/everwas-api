package com.theneilist.everwas.mapper;

import com.theneilist.everwas.api.Category;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements ResultSetMapper<Category> {

    public Category map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Category(r.getLong("id"), r.getLong("parent_id"), r.getString("name"));
    }

}
