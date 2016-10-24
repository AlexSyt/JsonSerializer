package com.company;

import java.io.IOException;
import java.io.Writer;

public class JsonWriter {
    Writer writer;

    public JsonWriter(Writer writer) {
        this.writer = writer;
    }

    protected void writeObjectBegin() throws IOException {
        writer.append('{');
    }

    protected void writeObjectEnd() throws IOException {
        writer.append('}');
    }

    protected void writeArrayBegin() throws IOException {
        writer.append('[');
    }

    protected void writeArrayEnd() throws IOException {
        writer.append(']');
    }

    protected void writeString(String s) {

    }

    protected void writeNumber(Number num) {

    }

    protected void writeSeparator() {

    }

    protected void writePropertySeparator() {

    }

    protected void writeBoolean() {

    }

    protected void writeNull() {

    }

    protected void flush() {

    }
}
