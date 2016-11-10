package com.company;

import java.io.IOException;

public class NumberMapper implements JsonMapper {
    @Override
    public void write(Object obj, JsonWriter writer) throws IOException {
        writer.writeNumber((Number) obj);
    }
}
