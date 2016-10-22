package com.theneilist.everwas.api.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.OffsetDateTime;

public class OffsetDateTimeSerializer  extends JsonSerializer<OffsetDateTime> {
    @Override
    public void serialize(OffsetDateTime arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException, JsonProcessingException {
        arg1.writeString(arg0.toString());
    }
}
