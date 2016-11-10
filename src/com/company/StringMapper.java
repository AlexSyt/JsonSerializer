package com.company;

import java.io.IOException;

public class StringMapper implements JsonMapper {
    @Override
    public void write(Object obj, JsonWriter writer) {
        try {
            writer.writeString((String) obj);
        } catch (IOException e) {
            // catch exception
        }
    }
}
