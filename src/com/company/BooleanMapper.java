package com.company;

import java.io.IOException;

public class BooleanMapper implements JsonMapper {
    private JsonSerializer serializer;

    public BooleanMapper(JsonSerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public void write(Object obj, JsonWriter writer) {
        try {
            writer.writeBoolean((Boolean) obj);
        } catch (IOException e) {
            // catch exception
        }
    }
}
