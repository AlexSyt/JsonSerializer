package com.company.mappers;

import com.company.JsonSerializer;
import com.company.JsonWriter;

import java.io.IOException;

public class ObjectArrayMapper implements JsonMapper {
    private JsonSerializer serializer;

    public ObjectArrayMapper(JsonSerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public void write(Object obj, JsonWriter writer) throws IOException {
        if (obj != null) {
            Object[] arr = (Object[]) obj;
            writer.writeArrayBegin();
            for (int i = 0; i < arr.length; i++) {
                serializer.serialize(arr[i], writer);
                if (i != arr.length - 1) writer.writeSeparator();
            }
            writer.writeArrayEnd();
        } else writer.writeNull();
    }
}
