package com.company;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class JsonSerializer {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private boolean indent;
    private Map<Class, JsonMapper> mappersCache;

    public JsonSerializer() {
        mappersCache = new HashMap<>();
        mappersCache.put(String.class, new StringMapper());
        mappersCache.put(Boolean.class, new BooleanMapper());
        mappersCache.put(Number.class, new NumberMapper());
        mappersCache.put(Collection.class, new CollectionMapper(this));
        mappersCache.put(Map.class, new MapMapper(this));
        mappersCache.put(Object[].class, new ObjectArrayMapper(this));
        mappersCache.put(boolean[].class, new PrimitiveArrayMapper(this));
        mappersCache.put(byte[].class, new PrimitiveArrayMapper(this));
        mappersCache.put(char[].class, new PrimitiveArrayMapper(this));
        mappersCache.put(short[].class, new PrimitiveArrayMapper(this));
        mappersCache.put(int[].class, new PrimitiveArrayMapper(this));
        mappersCache.put(long[].class, new PrimitiveArrayMapper(this));
        mappersCache.put(float[].class, new PrimitiveArrayMapper(this));
        mappersCache.put(double[].class, new PrimitiveArrayMapper(this));
    }

    public JsonMapper getMapper(Class clazz) {
        if (mappersCache.containsKey(clazz))
            return mappersCache.get(clazz);
        else return null;
    }

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
