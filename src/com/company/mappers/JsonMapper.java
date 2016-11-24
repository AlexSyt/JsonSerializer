package com.company.mappers;

import com.company.JsonWriter;

import java.io.IOException;

public interface JsonMapper {
    void write(Object obj, JsonWriter writer) throws IOException;
}
