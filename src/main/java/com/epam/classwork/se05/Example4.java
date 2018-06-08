package com.epam.classwork.se05;

import java.io.IOException;

public class Example4 {

    public static void main(String[] args) throws IOException {
        String valueInMain = "main";
        method1();
        System.out.println(valueInMain);
    }

    public static void method1() throws IOException {
        int valueInMethod1 = 14;
        if (false) {
            throw new IOException("My exception");
        }
        method2();
        System.out.println(valueInMethod1);
    }

    public static void method2() throws IOException {
        throw new IOException("My exception");
    }
}
