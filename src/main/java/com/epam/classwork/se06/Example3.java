package com.epam.classwork.se06;

public class Example3 {

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.getValue());
    }
}

interface MyInterface {

    default int getValue() {
        return -42;
    }
}

class A {

    private int getValue() {
        return 55;
    }
}

class B extends A implements MyInterface {

}