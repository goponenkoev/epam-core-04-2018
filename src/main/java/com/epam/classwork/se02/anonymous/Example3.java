package com.epam.classwork.se02.anonymous;

import java.util.Comparator;

public class Example3 {

    private int value = 55;

    public void method() {
        Comparator<String> comparator = new Comparator<>() {

            @Override
            public int compare(String o1, String o2) {
                System.out.println(value);
                return 0;
            }
        };
    }

}


