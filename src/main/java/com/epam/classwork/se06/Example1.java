package com.epam.classwork.se06;

public class Example1 {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 256; ++i) {
            builder.append((char)i);
        }
        String original = builder.toString();
        String modified = original.toUpperCase().toLowerCase();
        System.out.println(Integer.compare(original.length(), modified.length()));

        System.out.println(original.length());
        System.out.println(modified.length());
        System.out.println(original);
        System.out.println(modified);
    }

    // a) -1
    // b) 0
    // c) 1
    // d) зависит от чего-то
}
