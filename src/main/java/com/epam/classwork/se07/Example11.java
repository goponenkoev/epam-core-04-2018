package com.epam.classwork.se07;

import lombok.SneakyThrows;

public class Example11 {

    private static int value = 0;

    private static synchronized void inc() {
        value++;
    }

    private static void synchroInc() {
        synchronized (Example11.class) {
            value++;
        }
    }

    private synchronized void method() {
        sycnrhoMethod();
    }

    private void sycnrhoMethod() {
        synchronized (this) {
            throwException();
            System.out.println("123");
        }
    }

    private void throwException() {
        throw new RuntimeException();
    }

    @SneakyThrows
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; ++i) {
                    inc();
                }
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("value = " + value);
    }
}

