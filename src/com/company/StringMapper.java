package com.company;

import java.io.IOException;

public class StringMapper implements JsonMapper {
    @Override
    public void write(Object obj, JsonWriter writer) throws IOException {
        if (obj != null)
            writer.writeString((String) obj);
        else writer.writeNull();
    }
}
