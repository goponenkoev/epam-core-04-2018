package com.epam.classwork.se07.concurrent;

import java.util.concurrent.*;

public class Example3 {

    public static void main(String[] args) {
        ThreadFactory factory = new ThreadFactory() {

            private int number = 0;

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("worker-" + number++);
                return thread;
            }
        };
        ExecutorService service = new ThreadPoolExecutor(4, 16, 60, TimeUnit.SECONDS, new MyBlockingQueue(), factory);
//        service.submit(() -> System.out.println(Thread.currentThread()));
//        service.submit(() -> System.out.println(Thread.currentThread()));
//        service.submit(() -> System.out.println(Thread.currentThread()));
//        service.submit(() -> System.out.println(Thread.currentThread()));
//        service.submit(() -> System.out.println(Thread.currentThread()));
//        service.submit(() -> System.out.println(Thread.currentThread()));


        System.out.println(((ThreadPoolExecutor) service).getPoolSize());
        ExecutorService unconfigurableService = Executors.unconfigurableExecutorService(service);
        execute2(unconfigurableService);
    }

    private static void execute1(ExecutorService service) {
        service.submit(() -> System.out.println("Hello from good guy"));

    }

    private static void execute2(ExecutorService service) {
        ((ThreadPoolExecutor) service).setCorePoolSize(1);
        ((ThreadPoolExecutor) service).setMaximumPoolSize(1);
        service.submit(() -> System.out.println("Hello from good guy"));

    }
}

class MyBlockingQueue extends SynchronousQueue<Runnable> {

    @Override
    public void put(Runnable t) throws InterruptedException {
        System.out.println("Some task incoming" + t);
        super.put(t);
    }

    @Override
    public boolean offer(Runnable t) {
        System.out.println("Some task incoming" + t);
        return super.offer(() -> {
            t.run();
            System.out.println("After execute: " + t);
        });
    }
}