package com.epam.classwork.se07.concurrent;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Example6 {

    private final static AtomicInteger value = new AtomicInteger();

    @SneakyThrows
    public static void main(String[] args) {
        // Compare
        // And
        // Swap / Set

        Lock latch = new ReentrantLock(true);
        Runnable task = new Runnable() {
            @Override
            public void run() {
//                int previos;
//                int next;
//                do {
//                    previos = value.get();
//                    next = getNext(previos);
//                } while (!value.compareAndSet(previos, next));

//                latch.lock();
//                try {
//                    int previous = value.get();
//                    int next = getNext(previous);
//                    value.set(next);
//                } finally {
//                    latch.unlock();
//                }

                // 0
                value.incrementAndGet();
                // 1
            }

            @SneakyThrows
            private int getNext(int previos) {
                TimeUnit.SECONDS.sleep(1);
                return previos + 1;
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
}
