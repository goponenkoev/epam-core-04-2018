package com.epam.classwork.se07.concurrent;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example9 {

    public static void main(String[] args) {
        // PECS
        List<? extends Number> list = Arrays.asList(1, 2, 3);
        Number integer = list.get(0);

        List<? super Number> consumer = new ArrayList<Object>();
        consumer.add(1);
        consumer.add(1d);
        consumer.add(1L);


        Matrix<Integer> integerMatrix = new Matrix<>();

    }

    private static <T extends Number> void method(List<? extends T> list) {
        T t = list.get(0);
    }
}

class Matrix <T extends Number> {

    private Object[] values = new Object[10];


    T getVal(int i) {
        return (T) values[i];
    }
}