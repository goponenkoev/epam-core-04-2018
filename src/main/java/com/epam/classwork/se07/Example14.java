package com.epam.classwork.se07;

import java.util.concurrent.TimeUnit;

public class Example14 {

    public static void main(String[] args) throws InterruptedException {
        Object condition = new Object();

        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("I'm here");

                synchronized (condition) {
                    condition.notifyAll();
                }

                synchronized (condition) {
                    condition.notify();
                }

                System.out.println("Thread-0 ends");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        synchronized (condition) {
            condition.wait();
            System.out.println("123");
        }

        System.out.println("Main ends");
    }
}
