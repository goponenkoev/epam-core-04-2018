package com.epam.classwork.se07;

import java.util.concurrent.TimeUnit;

public class Example14 {

    private static volatile long value = 0;

    public static void main(String[] args) throws InterruptedException {
        Object condition = new Object();

        value++;
        // read
        // -----
        // inc
        // -----
        // store


        Thread thread = new Thread(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(3);
                System.out.println("I'm here");
                value = 500000000000L;

                synchronized (condition) {
                    condition.notify();
                }

                System.out.println("Thread-0 ends");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        });
        thread.start();


        System.out.println(value);
        synchronized (condition) {
            while (value == 0) {
                condition.wait();
            }
            System.out.println("Value = " + value);
        }

        System.out.println("Main ends");
    }
}
