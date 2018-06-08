package com.epam.classwork.se07;

import java.util.concurrent.TimeUnit;

public class Example5 {

    public static void main(String[] args) throws InterruptedException {
        Runnable counterTask = new Runnable() {
            @Override
            public void run() {
                long value = 0;
                while (!Thread.currentThread().isInterrupted()) {
                    ++value;
                }
                System.out.println(Thread.currentThread().getName() + " after = " + value);
            }
        };

        TimeUnit.SECONDS.sleep(10);

        Thread counter1 = new Thread(counterTask);
        counter1.setName("Max");
        counter1.setPriority(Thread.MAX_PRIORITY);

        Thread counter2 = new Thread(counterTask);
        counter2.setName("Min");
        counter2.setPriority(Thread.MIN_PRIORITY);

        counter1.start();
        counter2.start();

        TimeUnit.SECONDS.sleep(3);

        counter1.interrupt();
        counter2.interrupt();

    }
}
