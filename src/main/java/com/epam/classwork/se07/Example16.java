package com.epam.classwork.se07;

import java.util.concurrent.TimeUnit;

public class Example16 {

    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();

        new Thread(() -> {
            synchronized (a) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    synchronized (b) {
                        System.out.println("From 1");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (a) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    synchronized (b) {
                        System.out.println("From 2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
