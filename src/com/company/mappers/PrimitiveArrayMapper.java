package com.company.mappers;

import com.company.JsonSerializer;
import com.company.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Array;

public class PrimitiveArrayMapper implements JsonMapper {
    private JsonSerializer serializer;

    public PrimitiveArrayMapper(JsonSerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public void write(Object obj, JsonWriter writer) throws IOException {
        if (obj != null) {
            int size = Array.getLength(obj);
            writer.writeArrayBegin();
            for (int i = 0; i < size; i++) {
                Object forSer = Array.get(obj, i);
                if (forSer != null)
                    serializer.serialize(forSer, writer);
                else writer.writeNull();
                if (i != size - 1) writer.writeSeparator();
            }
            writer.writeArrayEnd();
        } else writer.writeNull();
    }
}
