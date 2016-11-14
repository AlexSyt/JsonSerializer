package com.company;

import java.io.IOException;

public class BooleanMapper implements JsonMapper {
    @Override
    public void write(Object obj, JsonWriter writer) throws IOException {
        if (obj != null)
            writer.writeBoolean((Boolean) obj);
        else writer.writeNull();
    }
}
