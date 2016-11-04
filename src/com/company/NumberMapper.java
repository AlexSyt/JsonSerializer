package com.company;

import java.io.IOException;

public class NumberMapper implements JsonMapper {
    private JsonSerializer serializer;

    public NumberMapper(JsonSerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public void write(Object obj, JsonWriter writer) {
        try {
            writer.writeNumber((Number) obj);
        } catch (IOException e) {
            // catch exception
        }
    }
}
