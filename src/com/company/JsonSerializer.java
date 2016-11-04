package com.company;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public class JsonSerializer {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private boolean indent;

    public boolean isIndent() {
        return indent;
    }

    public void setIndent(boolean indent) {
        this.indent = indent;
    }

    public String serialize(Object obj) {
        throw new IllegalStateException();
    }

    public void serialize(Object obj, OutputStream stream) {
        serialize(obj, stream, DEFAULT_CHARSET);
    }

    public void serialize(Object obj, OutputStream stream, Charset charset) {
        serialize(obj, new OutputStreamWriter(stream, charset));
    }

    public void serialize(Object obj, JsonWriter jWriter) {

    }

    public void serialize(Object obj, Writer writer) {
    }
}
