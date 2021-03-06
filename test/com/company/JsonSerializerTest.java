package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

class TestItem {
    @Expose
    private int testData;
    @Ignore
    int[] testArray;

    public TestItem(int testData, int[] testArray) {
        this.testData = testData;
        this.testArray = testArray;
    }

    public int getTestData() {
        return ++testData;
    }

    public void setTestData(int testData) {
        this.testData = testData;
    }

    public Calendar getCalendar() {
        return Calendar.getInstance();
    }
}

public class JsonSerializerTest {
    @Test
    public void serialize() throws Exception {
        JsonSerializer ser = new JsonSerializer();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        Integer[] arrInt1 = {1, 2, 3, 4, 5};
        Integer[] arrInt2 = {11, null, 33, 44, 55};
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
        list2.add(null);

        Map<String, ArrayList<Integer[]>> mapTest = new HashMap<>();
        mapTest.put("list1", list1);
        mapTest.put("list2", list2);


        List<Map<String, LinkedList<Double[]>>> listTest = new ArrayList<>();

        Double[] arrD1 = {1.5, 2.5, 3.5};
        Double[] arrD2 = {2.5, 3.5, 4.5};
        Double[] arrD11 = {3.5, 4.5, 5.5};
        Double[] arrD22 = {null, 5.5, 6.5};

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

        TestItem testItem = new TestItem(3, new int[]{1, 2, 3, 4, 5, 6, 7});
        assertEquals(gson.toJson(testItem), ser.serialize(testItem));
    }
}