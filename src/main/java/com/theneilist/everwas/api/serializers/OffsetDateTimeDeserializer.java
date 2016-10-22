package com.theneilist.everwas.api.serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.OffsetDateTime;

public class OffsetDateTimeDeserializer  extends JsonDeserializer<OffsetDateTime> {
    @Override
    public OffsetDateTime deserialize(JsonParser arg0, DeserializationContext arg1) throws IOException, JsonProcessingException {
        return OffsetDateTime.parse(arg0.getText());
    }
}