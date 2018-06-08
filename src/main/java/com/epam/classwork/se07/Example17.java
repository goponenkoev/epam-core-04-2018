package com.epam.classwork.se07;

import java.util.concurrent.TimeUnit;

public class Example17 {

    public static void main(String[] args) throws InterruptedException {
        Thread spamer = new Thread(() -> {
            while (true) {
                System.out.println("123");
            }
        });
        spamer.start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                spamer.resume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        spamer.suspend();

        System.out.println(spamer.getState());
        System.out.println("Main ends");
    }
}
