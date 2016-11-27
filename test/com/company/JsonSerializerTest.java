package com.company;

import org.junit.Test;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class JsonSerializerTest {
    @Test
    public void serialize() throws Exception {
        JsonSerializer ser = new JsonSerializer();
        Integer[] arr = {1, 2, 3, 4, 5};
        ArrayList<Integer> toSer = new ArrayList<>(Arrays.asList(arr));
        StringWriter sw = new StringWriter();
        ser.serialize(toSer, sw);
        assertEquals("[1,2,3,4,5]", sw.toString());
    }
}