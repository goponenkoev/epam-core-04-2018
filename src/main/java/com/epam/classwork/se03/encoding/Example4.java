package com.epam.classwork.se03.encoding;

public class Example4 {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("abcde");
        builder.append("f");
        System.out.println(builder.capacity());
        System.out.println(builder.length());

        builder.setLength(0);
        System.out.println(builder);
        System.out.println(builder.capacity());
        System.out.println(builder.length());

        builder.append("q");
        System.out.println(builder.capacity());
        System.out.println(builder.length());
        System.out.println(builder);
    }
}
