package com.company;

public interface JsonMapper<T> {
    void write(T obj, JsonWriter writer);
}
