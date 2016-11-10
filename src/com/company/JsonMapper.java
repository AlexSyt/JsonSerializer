package com.company;

import java.io.IOException;

public interface JsonMapper {
    void write(Object obj, JsonWriter writer) throws IOException;
}
