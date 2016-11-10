package com.company;

import java.io.IOException;

public class StringMapper implements JsonMapper {
    @Override
    public void write(Object obj, JsonWriter writer) throws IOException {
        writer.writeString((String) obj);
    }
}
