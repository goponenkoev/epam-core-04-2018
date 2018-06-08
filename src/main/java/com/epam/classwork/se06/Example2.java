package com.epam.classwork.se06;

import java.util.HashMap;

public class Example2 {

    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put(map, 1);
        System.out.println(map.get(map));
    }
}
