package com.company;

import java.io.IOException;

public class BooleanMapper implements JsonMapper {
    @Override
    public void write(Object obj, JsonWriter writer) {
        try {
            writer.writeBoolean((Boolean) obj);
        } catch (IOException e) {
            // catch exception
        }
    }
}
