package com.epam.classwork.se02.java8;

public class Example2 {

    public static void main(String[] args) {
        A implementation = new Implementation();
        implementation.method();
    }
}


interface A {

    default void method() {
        System.out.println("From A interface");
    }

}


class Base {

    public void method() {
        System.out.println("From base class");
    }
}

class Implementation extends Base implements A {
}
