package com.epam.classwork.se05;

import lombok.SneakyThrows;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Example11 {

    public static void main(String[] args) {
        method2();
    }

    @SneakyThrows
    public static void method1() {
        try (InputStream arr = new ByteArrayInputStream(new byte[]{1, 2, 3})) {

        }
    }

    public static void method2() {
        throwUnchecked(new IOException());
    }

    public static <T extends Throwable> void throwUnchecked(Throwable ref) throws T {
        throw (T)ref;
    }
}
