package com.epam.classwork.se07;

public class Example9 {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> System.out.println("Default handler"));
        MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
        new Thread(threadGroup, () -> {
            throw new RuntimeException("Exception from Thread-0");
        }).start();

        new Thread(() -> {
            throw new RuntimeException("Exception from Thread-1");
        }).start();

        Thread thread2 = new Thread(threadGroup, () -> {
            throw new RuntimeException("Exception from Thread-2");
        });
        thread2.setUncaughtExceptionHandler((t, e) -> System.out.println("Handler in thread"));
        thread2.start();

    }
}

class MyThreadGroup extends ThreadGroup {

    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Handler in threadGroup");
    }
}