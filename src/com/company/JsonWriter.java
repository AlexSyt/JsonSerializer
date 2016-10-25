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

    protected void writeString(String s) throws IOException {
        writer.append('"');
        for (int i = 0; i < s.length() - 1; i++) {
            Character ch = s.charAt(i);
            if (ch <= 31 || ch == '"' || ch == '/' || ch == '\\') {
                writer.append("\\u00");
                writer.append(Integer.toString(s.codePointAt(i), 16));
            } else
                writer.append(ch);
        }
        writer.append('"');
    }

    protected void writeNumber(Number num) throws IOException {
        writer.append(num.toString());
    }

    protected void writeSeparator() throws IOException {
        writer.append(',');
    }

    protected void writePropertySeparator() throws IOException {
        writer.append(':');
    }

    protected void writeBoolean() {

    }

    protected void writeNull() {

    }

    protected void flush() {

    }
}
