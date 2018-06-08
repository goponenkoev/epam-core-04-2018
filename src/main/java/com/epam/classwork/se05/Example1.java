package com.epam.classwork.se05;

import lombok.Value;

import java.util.concurrent.ThreadLocalRandom;

public class Example1 {


    public static void main(String[] args) {
        ReturnValue<String> result = getString();

        String reallyResult = handleError(result);
    }

    // Single responibility principle
    // Open/closed principle
    // Liskov substitution principle
    // Interface segregation
    // Dependency inverions
    public static <T> T handleError(ReturnValue<T> returnValue) {
        switch (returnValue.getRetCode()) {
            case 0:
                return returnValue.getValue();

            case 42:
                System.out.println("Something going wrong!");


            default:
                System.exit (returnValue.getRetCode());
        }
        return null;
    }

    public static ReturnValue<String> getString() {
        if (ThreadLocalRandom.current().nextBoolean()) {
            return new ReturnValue<>("abc", 0);
        } else {
            return new ReturnValue<>(null, 42);
        }
    }

}



@Value
class ReturnValue<T> {

    T value;
    int retCode;
}

class Launcher {

    public static void main(String[] args) {
        A a = new B();
        Object value = a.getValue();
        System.out.println(value);
    }
}

class A {

    public Object getValue() {
        return 42;
    }
}


class B extends A {

    @Override
    public String getValue() {
        throw new RuntimeException();
    }
}