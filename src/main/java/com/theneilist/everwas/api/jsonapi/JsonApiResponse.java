package com.theneilist.everwas.api.jsonapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonApiResponse {

    private Object data;

    public JsonApiResponse(Object data) {
        this.data = data;
    }

    @JsonProperty
    public Object getData() {
        return data;
    }

}
