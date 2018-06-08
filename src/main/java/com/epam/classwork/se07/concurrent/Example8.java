package com.epam.classwork.se07.concurrent;

import lombok.SneakyThrows;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Example8 {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(2, () -> {
            System.out.println("Barrier full");
        });
        new Thread(new Runnable() {
            @Override
            @SneakyThrows
            public void run() {
                while (true) {
                    TimeUnit.SECONDS.sleep(1);
                    barrier.await();
                    System.out.println("After barrier in thread-0");
                }
            }
        }).start();

        while (true) {
            barrier.await();
            System.out.println("After barrier in main");
        }
    }
}
