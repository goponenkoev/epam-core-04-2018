package com.epam.classwork.se07.concurrent;

import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.*;

public class Example2 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Runnable task = new Runnable() {
            @Override
            @SneakyThrows
            public void run() {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Hello from runnable");

            }
        };
        Future<?> hello = service.submit(task);

        System.out.println("Before get");
        try {
            Object result = hello.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("After get");
        service.submit(task);
        service.submit(task);
        List<Runnable> tasks = service.shutdownNow();
        System.out.println(tasks.size());
        service.submit(task);
    }
}
