package com.epam.classwork.se05;

public class Example7 {

    public static void main(String[] args) {
        method(0);
    }

    private static void method(int level) {
        if (level == 5) {
            throw new StackOverflowError();
        }
        try {
            System.out.println(level);
            method(level + 1);
        } catch (StackOverflowError ex) {
            System.out.println("SO: " + level);
            method(level + 1);
        }
    }
}

