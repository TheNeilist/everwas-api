package com.theneilist.everwas.dao;

import com.theneilist.everwas.api.AuthenticationCredentials;
import com.theneilist.everwas.api.User;
import com.theneilist.everwas.mapper.UserMapper;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.customizers.SingleValueResult;

import java.util.Optional;

public interface UserDao {

    @SqlQuery("select * from everwas.user where username = :creds.username and password = :creds.password")
    @SingleValueResult(User.class)
    @Mapper(UserMapper.class)
    Optional<User> findByCredentials(@BindBean("creds") AuthenticationCredentials creds);

}
