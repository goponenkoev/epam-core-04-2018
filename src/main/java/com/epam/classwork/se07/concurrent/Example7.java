package com.epam.classwork.se07.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Example7 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                latch.countDown();
                latch.await();
                System.out.println("Hello from " + Thread.currentThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(task).start();
        new Thread(task).start();

        System.out.println("Before");
        latch.await();
        System.out.println("After");


        System.out.println("Main ends");
    }
}
