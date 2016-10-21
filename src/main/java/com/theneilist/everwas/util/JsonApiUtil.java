package com.theneilist.everwas.util;

import com.theneilist.everwas.api.jsonapi.JsonApiBaseEntity;
import com.theneilist.everwas.api.jsonapi.JsonApiData;
import com.theneilist.everwas.api.jsonapi.JsonApiResponse;

import java.util.ArrayList;
import java.util.List;

public class JsonApiUtil {

    public static JsonApiResponse getPayloadResponse(JsonApiBaseEntity entity) {
        return new JsonApiResponse(new JsonApiData(entity.getType(), String.valueOf(entity.getId()), entity));
    }

    public static JsonApiResponse getPayloadListResponse(List<JsonApiBaseEntity> entities) {
        List<JsonApiData> data = new ArrayList<>();
        for (JsonApiBaseEntity entity : entities) {
            data.add(new JsonApiData(entity.getType(), String.valueOf(entity.getId()), entity));
        }
        return new JsonApiResponse(data);
    }
}
