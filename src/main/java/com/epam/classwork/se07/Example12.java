package com.epam.classwork.se07;

import java.util.concurrent.TimeUnit;

public class Example12 {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread thread = new Thread(counter);
        thread.start();

        TimeUnit.SECONDS.sleep(2);

        counter.setState(Counter.State.STOPPED);
        System.out.println("Main ends: " + counter.getValue());
    }
}


