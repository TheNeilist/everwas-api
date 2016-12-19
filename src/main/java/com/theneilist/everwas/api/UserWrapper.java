package com.theneilist.everwas.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserWrapper {

    private User user;

    public UserWrapper() {
    }

    public UserWrapper(User user) {
        this.user = user;
    }

    @JsonProperty
    public User getUser() {
        return user;
    }
}
