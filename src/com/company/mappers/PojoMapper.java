package com.company.mappers;

import com.company.JsonSerializer;
import com.company.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Field;

public class PojoMapper implements JsonMapper {
    private JsonSerializer serializer;
    private final Field[] fields;

    public PojoMapper(JsonSerializer serializer, Class clazz) {
        this.serializer = serializer;
        fields = clazz.getDeclaredFields();
    }

    @Override
    public void write(Object obj, JsonWriter writer) throws IOException {
        if (obj != null) {
            writer.writeObjectBegin();
            for (int i = 0; i < fields.length; i++) {
                Field f = fields[i];
                f.setAccessible(true);
                writer.writeString(f.getName());
                writer.writePropertySeparator();
                try {
                    serializer.serialize(f.get(obj));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (i != fields.length - 1) writer.writeSeparator();
            }
            writer.writeObjectEnd();
        } else writer.writeNull();
    }
}
