package com.epam.classwork.se07;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Example1 {

    public static void main(String[] args) throws InterruptedException {
        Talk talking = new Talk();
        System.out.println(talking.getState()); // NEW
        talking.start();
        System.out.println(talking.getState()); // RUNNABLE / TIMED_WAITING

        Thread walking = new Thread(new Walk());
        walking.start();

        TimeUnit.SECONDS.sleep(2);

        Thread main = Thread.currentThread();
        System.out.println(main.getState());       // RUNNABLE
        System.out.println(talking.getState());    // RUNNABLE / TIMED_WAITING / BLOCKED


        TimeUnit.SECONDS.sleep(7);
        System.out.println(talking.getState()); // TERMINATED
    }
}


class Walk implements Runnable {

    @Override
    @SneakyThrows
    public void run() {
        for (int i = 0; i < 8; i++) {
            System.out.println("Walking");
            TimeUnit.SECONDS.sleep(1);
        }
    }
}

class Talk extends Thread {

    @Override
    @SneakyThrows
    public void run() {
        for (int i = 0; i < 8; i++) {
            System.out.println("Talking");
            TimeUnit.SECONDS.sleep(1);

        }
    }
}

