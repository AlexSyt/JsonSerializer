package com.company.mappers;

import com.company.JsonWriter;

import java.io.IOException;

public class CharacterMapper implements JsonMapper {
    @Override
    public void write(Object obj, JsonWriter writer) throws IOException {
        if (obj != null)
            writer.writeString(obj.toString());
        else writer.writeNull();
    }
}
