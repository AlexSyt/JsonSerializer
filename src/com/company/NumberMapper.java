package com.company;

import java.io.IOException;

public class NumberMapper implements JsonMapper {
    @Override
    public void write(Object obj, JsonWriter writer) {
        try {
            writer.writeNumber((Number) obj);
        } catch (IOException e) {
            // catch exception
        }
    }
}
