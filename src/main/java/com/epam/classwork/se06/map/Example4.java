package com.epam.classwork.se06.map;

import java.util.EnumMap;
import java.util.Map;

public class Example4 {

    public static void main(String[] args) {
        Map<State, Integer> map = new EnumMap<>(State.class);
        map.put(State.RUN, 10);
        map.put(State.STARTED, 20);

        System.out.println(map.get(State.PAUSED));
        System.out.println(map.get(State.STARTED));
    }
}

enum State {
    RUN,
    STARTED,
    PAUSED
}