package com.theneilist.everwas.api.jsonapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonApiData {

    private String type;
    private String id;
    private Object attributes;
    private Object relationships;

    public JsonApiData(String type, String id, Object attributes) {
        this.type = type;
        this.id = id;
        this.attributes = attributes;
    }

    public JsonApiData(String type, String id, Object attributes, Object relationships) {
        this.type = type;
        this.id = id;
        this.attributes = attributes;
        this.relationships = relationships;
    }

    @JsonProperty
    public String getType() {
        return type;
    }

    @JsonProperty
    public String getId() {
        return id;
    }

    @JsonProperty
    public Object getAttributes() {
        return attributes;
    }

    @JsonProperty
    public Object getRelationships() {
        return relationships;
    }
}
