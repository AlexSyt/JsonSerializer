package com.company.mappers;

import com.company.JsonSerializer;
import com.company.JsonWriter;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class MapMapper implements JsonMapper {
    private JsonSerializer serializer;

    public MapMapper(JsonSerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public void write(Object obj, JsonWriter writer) throws IOException {
        if (obj != null) {
            Map<String, ?> map = (Map<String, ?>) obj;
            Iterator iter = map.entrySet().iterator();
            writer.writeObjectBegin();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                writer.writeString((String) entry.getKey());
                writer.writePropertySeparator();
                Object forSer = entry.getValue();
                if (forSer != null)
                    serializer.serialize(forSer, writer);
                else writer.writeNull();
                if (iter.hasNext()) writer.writeSeparator();
            }
            writer.writeObjectEnd();
        } else writer.writeNull();
    }
}
