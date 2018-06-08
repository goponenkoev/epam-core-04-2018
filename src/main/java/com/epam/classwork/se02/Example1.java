package com.epam.classwork.se02;

public class Example1 {

    public static void main(String[] args) {
        Example1 ref = new Example1();
        ref.printHello();
        ref.printHello(1);
    }

    public void printHello() {
        System.out.println("Hello world!");
        System.out.println(this);
    }

    public void printHello(int val) {
        System.out.println("Hello, " + val);
    }
}


