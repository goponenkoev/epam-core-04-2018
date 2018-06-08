package com.epam.classwork.se01;

public class Example2 {

    public static void main(String[] args) {
        int a = 128;
        Integer b = 128;

        if (a == b) {
            System.out.println("equals");
        } else {
            System.out.println("Not equals");
        }
    }


    // ref -> args
    // int -> a (4 bytes)
    // ref -> b
}
