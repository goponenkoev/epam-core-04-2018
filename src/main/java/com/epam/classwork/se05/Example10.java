package com.epam.classwork.se05;

public class Example10 {

    public static void main(String[] args) {
        try {
            System.out.println("Before exit");
            System.exit(10);
            System.out.println("After exit");
        } finally {
            System.out.println("Finally");
        }
    }
}
