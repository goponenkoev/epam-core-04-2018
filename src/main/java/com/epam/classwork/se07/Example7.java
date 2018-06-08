package com.epam.classwork.se07;

import java.util.concurrent.TimeUnit;

public class Example7 {

    public static void main(String[] args) throws InterruptedException {
        Runnable counterTask = new Runnable() {
            @Override
            public void run() {
                // false
                Thread.currentThread().interrupt();
                // true
                long value = 0;
                while (!Thread.interrupted()) {
                    ++value;
                }
                // false

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("Inside catch: " + Thread.currentThread().isInterrupted());
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " after = " + value);
            }
        };

        Thread counter1 = new Thread(counterTask);

        counter1.start();

        TimeUnit.SECONDS.sleep(3);

        counter1.interrupt();
    }
}
