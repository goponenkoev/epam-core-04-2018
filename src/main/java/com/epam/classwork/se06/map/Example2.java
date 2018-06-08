package com.epam.classwork.se06.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Example2 {

    public static void main(String[] args) {
        Map<MyClass, String> map = new TreeMap<>();
        MyClass holder1 = new MyClass(10);
        MyClass holder2 = new MyClass(10);

        String str = map.put(holder1, "abc");
        System.out.println(str);

        System.out.println(holder1);
        System.out.println(holder2);

        System.out.println(map.get(holder1));
        System.out.println(map.get(holder2));


//        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
//        linkedHashMap.put("Smith", 30);
//        linkedHashMap.put("Anderson", 31);
//        linkedHashMap.put("Lewis", 29);
//        linkedHashMap.put("Cook", 29);
//        System.out.println("\nThe age for " + "Lewis is " + linkedHashMap.get("Lewis"));
//        System.out.println(linkedHashMap);
    }
}

class MyClass implements Comparable<MyClass> {

    private final int field;


    MyClass(int field) {
        this.field = field;
    }

    @Override
    public int compareTo(MyClass o) {
        return Integer.compare(o.field, field);
    }
}