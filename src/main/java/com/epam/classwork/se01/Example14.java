package com.epam.classwork.se01;

import java.util.concurrent.ExecutionException;

public class Example14 {

    private static final String VERSION = "1.0.1";

    public void a() {
        b();
        c();

        System.out.println();
    }

    /**
     *
     * Версия - {@value Example14#VERSION}
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     */
    public void d() throws IllegalStateException, IllegalArgumentException {
        c();
    }

    private void c() {
        String str = "123";

        try {

        } catch (RuntimeException ignored) {}
    }

    private void b() {
    }
}
