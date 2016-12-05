package com.company.mappers;

import com.company.JsonSerializer;
import com.company.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class PojoMapper implements JsonMapper {
    private JsonSerializer serializer;
    private final ArrayList<Field> fields;

    public PojoMapper(JsonSerializer serializer, Class clazz) {
        this.serializer = serializer;
        ArrayList<Field> f = new ArrayList<>();
        for (Class cur = clazz; cur != Object.class; cur = cur.getSuperclass()) {
            for (Field field : cur.getDeclaredFields())
                f.add(field);
        }
        fields = f;
    }

    @Override
    public void write(Object obj, JsonWriter writer) throws IOException {
        if (obj != null) {
            writer.writeObjectBegin();
            for (int i = 0; i < fields.size(); i++) {
                Field f = fields.get(i);
                f.setAccessible(true);
                writer.writeString(f.getName());
                writer.writePropertySeparator();
                try {
                    serializer.serialize(f.get(obj));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (i != fields.size() - 1) writer.writeSeparator();
            }
            writer.writeObjectEnd();
        } else writer.writeNull();
    }
}
