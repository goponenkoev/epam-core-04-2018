package com.epam.classwork.se02.generics;

public class Example7 {

    public static void main(String[] args) {
        method(new Object());
    }

    public static <Type> void method(Type obj) {
        System.out.println("<Type> void method(Type obj)");
    }

    public static void method(Number obj) {
        System.out.println("void method(Number obj)");
    }

    public static void method(Integer obj) {
        System.out.println("void method(Integer obj)");
    }

    public static void method(String obj) {
        System.out.println("void method(String obj)");
    }

}
