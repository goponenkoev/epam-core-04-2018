package com.epam.classwork.se02.java8;

public class Example1 {

    public static void main(String[] args) {
        Callable ref = new ExternalCallable() {

            @Override
            public void call() {

            }
        };

        Callable.callOn(ref);
    }
}

@FunctionalInterface
interface Callable {

    void call();

    static void callOn(Callable ref) {
        ref.call();
    }
}

interface ExternalCallable extends Callable {

    void call();

    static void callOn(Callable ref) {
        ref.call();
    }
}