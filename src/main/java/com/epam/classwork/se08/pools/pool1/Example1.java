package com.epam.classwork.se08.pools.pool1;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Example1 {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(-1);

        new Thread(new Runnable() {
            @Override
            @SneakyThrows
            public void run() {
                TimeUnit.SECONDS.sleep(3);
                semaphore.release(2);
            }
        }).start();

        semaphore.acquireUninterruptibly(4);
        System.out.println(semaphore.availablePermits());


    }
}
