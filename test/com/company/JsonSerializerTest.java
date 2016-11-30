package com.company;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class JsonSerializerTest {
    @Test
    public void serialize() throws Exception {
        JsonSerializer ser = new JsonSerializer();
        Gson gson = new Gson();

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

        Map<String, ArrayList<Integer[]>> mapTest = new HashMap<>();
        mapTest.put("list1", list1);
        mapTest.put("list2", list2);



        List<Map<String, LinkedList<Double[]>>> listTest = new ArrayList<>();

        Double[] arrD1 = {1.5, 2.5, 3.5};
        Double[] arrD2 = {2.5, 3.5, 4.5};
        Double[] arrD11 = {3.5, 4.5, 5.5};
        Double[] arrD22 = {4.5, 5.5, 6.5};

        LinkedList<Double[]> l1 = new LinkedList<>();
        LinkedList<Double[]> l2 = new LinkedList<>();
        l1.add(arrD1);
        l1.add(arrD2);
        l2.add(arrD11);
        l2.add(arrD22);

        Map<String, LinkedList<Double[]>> m = new TreeMap<>();
        m.put("item1", l1);
        m.put("item2", l2);

        listTest.add(m);

        assertEquals(gson.toJson(mapTest), ser.serialize(mapTest));
        assertEquals(gson.toJson(listTest), ser.serialize(listTest));
    }
}