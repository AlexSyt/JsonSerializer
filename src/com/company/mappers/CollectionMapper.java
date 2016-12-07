package com.company.mappers;

import com.company.JsonSerializer;
import com.company.JsonWriter;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class CollectionMapper implements JsonMapper {
    private JsonSerializer serializer;

    public CollectionMapper(JsonSerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public void write(Object obj, JsonWriter writer) throws IOException {
        if (obj != null) {
            Collection<?> coll = (Collection<?>) obj;
            Iterator iter = coll.iterator();
            writer.writeArrayBegin();
            while (iter.hasNext()) {
                Object forSer = iter.next();
                if (forSer != null)
                    serializer.serialize(forSer, writer);
                else writer.writeNull();
                if (iter.hasNext()) writer.writeSeparator();
            }
            writer.writeArrayEnd();
        } else writer.writeNull();
    }
}
