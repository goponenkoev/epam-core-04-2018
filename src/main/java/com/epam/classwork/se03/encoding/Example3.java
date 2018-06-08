package com.epam.classwork.se03.encoding;

public class Example3 {

    public static void main(String[] args) {
        String a = "a";
        a = a + "b";
        a = a + "c";
        a = a + "d";
        System.out.println(a);

        StringBuilder builder = new StringBuilder();
        builder.append("a").append("b").append("c").append("d");
        System.out.println(builder);
        System.out.println(builder.substring(1));


        System.out.println(a.substring(1));
    }
}
