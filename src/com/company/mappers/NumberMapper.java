package com.company.mappers;

import com.company.JsonWriter;

import java.io.IOException;

public class NumberMapper implements JsonMapper {
    @Override
    public void write(Object obj, JsonWriter writer) throws IOException {
        if (obj != null)
            writer.writeNumber((Number) obj);
        else writer.writeNull();
    }
}
