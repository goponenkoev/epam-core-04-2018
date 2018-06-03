package com.epam.classwork.se07.concurrent;

import java.util.concurrent.Executor;

public class Example1 {

    private static Executor executor = task -> new Thread(task).start();

    public static void main(String[] args) {
        executor.execute(() -> System.out.println("Hello from " + Thread.currentThread()));
        executor.execute(() -> System.out.println("Hello from " + Thread.currentThread()));
        executor.execute(() -> System.out.println("Hello from " + Thread.currentThread()));

    }

}




