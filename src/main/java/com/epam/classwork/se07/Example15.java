package com.epam.classwork.se07;

import java.util.concurrent.TimeUnit;

public class Example15 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread-0 ends");
        });
        thread.start();

        thread.join();
        System.out.println("Main ends");

        // spirious wakeup
    }
}
