package com.company;

import java.io.IOException;

public class StringMapper implements JsonMapper {
    private JsonSerializer serializer;

    public StringMapper(JsonSerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public void write(Object obj, JsonWriter writer) {
        try {
            writer.writeString((String) obj);
        } catch (IOException e) {
            // catch exception
        }
    }
}
