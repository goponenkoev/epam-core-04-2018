package com.epam.classwork.se02;

public class Example12 {





    public static void main(String[] args) {

    }
}

interface Map {
    Object put(Object key, Object value);

    interface Entry {
        Object getKey();
        Object getValue();
    }
}

class MyMap implements Map {

    @Override
    public Object put(Object key, Object value) {
        return null;
    }
}

class MyEntry implements Map.Entry {

    @Override
    public Object getKey() {
        return null;
    }

    @Override
    public Object getValue() {
        return null;
    }
}

