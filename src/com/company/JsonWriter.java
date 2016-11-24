package com.company;

import java.io.IOException;
import java.io.Writer;

public class JsonWriter {
    protected Writer writer;

    public JsonWriter(Writer writer) {
        this.writer = writer;
    }

    public void writeObjectBegin() throws IOException {
        writer.append('{');
    }

    public void writeObjectEnd() throws IOException {
        writer.append('}');
    }

    public void writeArrayBegin() throws IOException {
        writer.append('[');
    }

    public void writeArrayEnd() throws IOException {
        writer.append(']');
    }

    public void writeString(String s) throws IOException {
        writer.append('"');
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch <= 31 || ch == '"' || ch == '/' || ch == '\\') {
                writer.append("\\u00");
                writer.append(Integer.toString((int) ch, 16));
            } else
                writer.append(ch);
        }
        writer.append('"');
    }

    public void writeNumber(Number num) throws IOException {
        writer.append(num.toString());
    }

    public void writeSeparator() throws IOException {
        writer.append(',');
    }

    public void writePropertySeparator() throws IOException {
        writer.append(':');
    }

    public void writeBoolean(Boolean bool) throws IOException {
        writer.append(bool.toString());
    }

    public void writeNull() throws IOException {
        writer.append("null");
    }

    public void flush() throws IOException {
        writer.flush();
    }
}
