package com.company;

import java.io.IOException;

public class BooleanMapper implements JsonMapper {
    @Override
    public void write(Object obj, JsonWriter writer) throws IOException {
        writer.writeBoolean((Boolean) obj);
    }
}
