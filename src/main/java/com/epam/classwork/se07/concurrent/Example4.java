package com.epam.classwork.se07.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Example4 {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        service.schedule(() -> System.out.println("From task"), 3, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(() -> System.out.println("From fixed rate"), 0, 1, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(() -> System.out.println("From fixed rate"), 1, 1, TimeUnit.SECONDS);
//        TimeUnit.MILLISECONDS.sleep(1);
        service.shutdown();
    }
}
