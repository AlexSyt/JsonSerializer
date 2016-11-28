package com.company;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class JsonSerializerTest {
    @Test
    public void serialize() throws Exception {
        Integer[] arrInt1 = {1, 2, 3, 4, 5};
        Integer[] arrInt2 = {11, 22, 33, 44, 55};
        Integer[] arrInt3 = {111, 222, 333, 444, 555};

        ArrayList<Integer[]> list1 = new ArrayList<>();
        list1.add(arrInt1);
        list1.add(arrInt2);
        list1.add(arrInt3);

        Integer[] arrInt11 = {01, 02, 03, 04, 05, 06};
        Integer[] arrInt12 = {011, 022, 033, 044, 055, 066};
        Integer[] arrInt13 = {011, 022, 033, 044, 055, 066};

        ArrayList<Integer[]> list2 = new ArrayList<>();
        list2.add(arrInt11);
        list2.add(arrInt12);
        list2.add(arrInt13);

        Map<String, ArrayList<Integer[]>> map = new HashMap<>();
        map.put("list1", list1);
        map.put("list2", list2);

        JsonSerializer ser = new JsonSerializer();
        Gson gson = new Gson();
        assertEquals(gson.toJson(map), ser.serialize(map));
    }
}