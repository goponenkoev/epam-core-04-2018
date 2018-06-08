package com.epam.classwork.se05;

import java.io.IOException;
import java.io.InputStream;

@SuppressWarnings("ALL")
public class Example5 {

    public static void main(String[] args) throws IOException {
        method();
    }

    private static void method() throws IOException {

        try {
            System.out.println("Before exception");
            if (true) {
                throw new RuntimeException("Runtime exception");
            }
            System.out.println("After exception");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalAccessError("Acces error");
        } finally {
            System.out.println("Finally");
            throw new RuntimeException("Another runtime ex");
        }
    }
}
