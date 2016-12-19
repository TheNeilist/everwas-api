package com.theneilist.everwas.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationCredentials {
    private String username;
    private String password;

    public AuthenticationCredentials() {
    }

    public AuthenticationCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @JsonProperty
    public String getUsername() {
        return username;
    }

    @JsonProperty
    public String getPassword() {
        return password;
    }

}
