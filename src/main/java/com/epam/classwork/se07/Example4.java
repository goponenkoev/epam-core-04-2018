package com.epam.classwork.se07;

import lombok.SneakyThrows;

public class Example4 {

    private static int value = 0;

    @SneakyThrows
    public static void main(String[] args) {

        Runnable task = () -> {
            for (int i = 0; i < 1_000_000_000; ++i) {
                ++value;
            }
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

//        TimeUnit.MILLISECONDS.sleep(5);

        thread1.join();
        System.out.println(thread1.isAlive());
        System.out.println(thread1.getState());
        thread2.join();
        System.out.println(thread2.isAlive());
        System.out.println(thread2.getState());

        System.out.println("value = " + value);
    }
}
