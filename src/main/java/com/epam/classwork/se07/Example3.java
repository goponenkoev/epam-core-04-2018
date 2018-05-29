package com.epam.classwork.se07;

public class Example3 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("I'm from Thread-0");
                System.out.println(Thread.currentThread());
            }
        });
        thread.start();
        new Thread(thread).start();
    }
}
