package com.epam.classwork.se07;

import java.util.concurrent.TimeUnit;

public class Example2 {

    public static void main(String[] args) throws InterruptedException {
        Thread main = Thread.currentThread();
        System.out.println(main);
        System.out.println(main.getId());

        new Thread(() -> {
            System.out.println(Thread.currentThread());
        }).start();
        new Thread(() -> {
            Thread thisTread = Thread.currentThread();
            System.out.println(thisTread);
            System.out.println(thisTread.getId());
        }, "AnotherThread").start();
        Thread anotherThread = new Thread(() -> {
            Thread thisTread = Thread.currentThread();
            System.out.println(thisTread);
            System.out.println(thisTread.getId());
        }, "AnotherThread");
        anotherThread.start();
        anotherThread.setName("Really another thread");

        TimeUnit.SECONDS.sleep(5);

    }
}
