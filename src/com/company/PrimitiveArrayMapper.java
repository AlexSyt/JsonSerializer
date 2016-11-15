package com.company;

import java.io.IOException;

public class PrimitiveArrayMapper implements JsonMapper {
    @Override
    public void write(Object obj, JsonWriter writer) throws IOException {
        if (obj != null) {

        } else writer.writeNull();
    }
}
