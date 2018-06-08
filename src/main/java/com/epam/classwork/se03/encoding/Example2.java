package com.epam.classwork.se03.encoding;

import java.util.Arrays;

public class Example2 {

    private int field1;
    private int field2;
    private int field3;
    private String field4;

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "123";
        String str3 = str1 + str2;

        String longString = "1 1 2 3 4 5 6     ";
        String[] split = longString.split(" ", 5);
        System.out.println(split.length);
        System.out.println(Arrays.toString(split));
    }

    @Override
    public String toString() {
        return field1 + " " + field2 + " " + field3 + " " + field4;
    }
}
