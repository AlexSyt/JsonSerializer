package com.company;

import com.company.mappers.*;

import java.io.IOException;
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
        mappersCache.put(Character.class, new CharacterMapper());
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

    private JsonMapper getMapper(Object obj) {
        Class clazz = obj.getClass();
        if (mappersCache.containsKey(clazz))
            return mappersCache.get(clazz);
        else if (obj instanceof Number)
            return mappersCache.get(Number.class);
        else if (obj instanceof Collection)
            return mappersCache.get(Collection.class);
        else if (obj instanceof Map)
            return mappersCache.get(Map.class);
        else if (clazz.isArray())
            return mappersCache.get(Object[].class);
        else throw new RuntimeException("wtf");
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

    public void serialize(Object obj, OutputStream stream) throws IOException {
        serialize(obj, stream, DEFAULT_CHARSET);
    }

    public void serialize(Object obj, OutputStream stream, Charset charset) throws IOException {
        serialize(obj, new OutputStreamWriter(stream, charset));
    }

    public void serialize(Object obj, JsonWriter jWriter) throws IOException {
        JsonMapper mapper = getMapper(obj);
        mapper.write(obj, jWriter);
    }

    public void serialize(Object obj, Writer writer) throws IOException {
        serialize(obj, new JsonWriter(writer));
    }
}
