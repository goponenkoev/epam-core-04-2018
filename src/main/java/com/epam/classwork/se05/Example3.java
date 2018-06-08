package com.epam.classwork.se05;

import java.nio.file.FileAlreadyExistsException;

public class Example3 {

    private static final String version;
    private static RuntimeException ex;

    static {
        ex = new RuntimeException();
        version = "123";
    }

    public static void main(String[] args) {
        method1();
    }

    public static void method1() {


        try {
            method2();
        } catch (RuntimeException ex) {
            ex.fillInStackTrace();
            throw ex;
        }
    }

    public static void method2() {
        throw createException();
    }

    private static RuntimeException createException() {
        Exception checked_exception = new Exception("Checked exception", new FileAlreadyExistsException("ANother"));

        return new RuntimeException("RuntimeEx", checked_exception);
    }
}
