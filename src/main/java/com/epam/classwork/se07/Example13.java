package com.epam.classwork.se07;

public class Example13 {

    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;

        Integer val = 500;
        System.out.println(System.identityHashCode(val));
        --val;
        System.out.println(System.identityHashCode(val));
    }
}
