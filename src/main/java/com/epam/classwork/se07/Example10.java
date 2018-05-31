package com.epam.classwork.se07;

import lombok.SneakyThrows;

public class Example10 {

    private static Integer value = 0;

    @SneakyThrows
    public static void main(String[] args) {
//        Object lock = new Object();
        Runnable task = () -> {
            for (int i = 0; i < 1_000_000; ++i) {
                synchronized (value) { // 2 3
                    ++value; //
                }
            }
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("value = " + value);
    }
}

