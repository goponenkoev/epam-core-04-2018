package com.epam.classwork.se07;

import java.util.concurrent.TimeUnit;

public class Example6 {

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        Runnable counterTask = new Runnable() {
            @Override
            public void run() {
                long value = 0;
                while (!Thread.currentThread().isInterrupted()) {
                    ++value;
                    Thread.yield();
                }
                System.out.println(Thread.currentThread().getName() + " after = " + value);
            }
        };

        Thread[] counters = new Thread[Runtime.getRuntime().availableProcessors() + 2];
        for (int i = 0; i < counters.length; ++i) {
            counters[i] = new Thread(counterTask);
            counters[i].setPriority(i < 4 ? Thread.MAX_PRIORITY : Thread.MIN_PRIORITY);
        }

        for (Thread counter : counters) {
            counter.start();
        }

        TimeUnit.SECONDS.sleep(3);

        for (Thread counter : counters) {
            counter.interrupt();
        }

        // Java
        // Microbenchmark
        // Harness
    }
}
