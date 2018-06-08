package com.epam.classwork.se07.concurrent;

import lombok.SneakyThrows;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Example5 {

    private static int value = 0;

    @SneakyThrows
    public static void main(String[] args) {
        Lock latch = new ReentrantLock(true);
        Runnable task = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; ++i) {
                    if (latch.tryLock(10, TimeUnit.SECONDS)) {
                        try {
                            inc();
                        } finally {
                            latch.unlock();
                        }
                    }
                }
            }
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("value = " + value);
    }

    private static void inc() {
//        if (ThreadLocalRandom.current().nextInt(0, 100) > 80) {
//            throw new RuntimeException();
//        }
        ++value;
    }
}
