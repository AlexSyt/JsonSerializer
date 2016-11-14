package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class ObjectArrayMapper implements JsonMapper {
    private JsonSerializer serializer;

    public ObjectArrayMapper(JsonSerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public void write(Object obj, JsonWriter writer) throws IOException {
        if (obj != null) {
            Object[] arr = (Object[]) obj;
            Iterator iter = Arrays.asList(arr).iterator();
            writer.writeArrayBegin();
            while (iter.hasNext()) {
                serializer.serialize(iter.next(), writer);
                if (iter.hasNext()) writer.writeSeparator();
            }
            writer.writeArrayEnd();
        } else writer.writeNull();
    }
}
