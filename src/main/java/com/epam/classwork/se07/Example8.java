package com.epam.classwork.se07;

import java.util.concurrent.TimeUnit;

public class Example8 {

    public static void main(String[] args) throws InterruptedException {
        Thread daemon = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Finally in daemon thread");
                }
                System.out.println("Hello from daemon thread");
            }
        });
        daemon.setDaemon(true);
        daemon.start();

        Thread mainThread = Thread.currentThread();
        Thread nonDaemon = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(mainThread.getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Non-daemon thread ends");
        });
        nonDaemon.start();

        daemon.join();
        System.out.println("Main ends");
    }
}
