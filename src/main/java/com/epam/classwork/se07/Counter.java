package com.epam.classwork.se07;

import lombok.SneakyThrows;

public class Counter implements Runnable {

    private volatile State current;
    private int value = 0;

    @Override
    @SneakyThrows
    public void run() {
        current = State.RUNNING;
        while (current != State.STOPPED) {
            ++value;
        }
        System.out.println("Counter ends: " + value);
    }

    public void setState(State state) {
        current = state;
    }

    public int getValue() {
        return value;
    }

    public enum State {
        RUNNING,
        STOPPED
    }
}
