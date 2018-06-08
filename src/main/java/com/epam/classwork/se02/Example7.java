package com.epam.classwork.se02;

import java.util.HashMap;
import java.util.Map;

public class Example7 {

    private int id;

    public Example7(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Example7 example7 = (Example7) o;

        return id == example7.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public static void main(String[] args) {
        Example7 ref1 = new Example7(1000);
        Example7 ref2 = new Example7(1000);

        Map<Example7, String> map = new HashMap<>();
        map.put(ref1, "123");
        String s = map.get(ref2);
        System.out.println("123");

    }
}
