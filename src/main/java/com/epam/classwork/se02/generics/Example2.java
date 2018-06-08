package com.epam.classwork.se02.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Example2 {

    public static void main(String[] args) {
        Holder<MyNumber> myNumberHolder = new Holder<>(new MyNumber());

//        Holder<Integer> integerHolder = new Holder<>(1);

        Collection<String> collection = new ArrayList<>();
        String result = Example2.max(collection, 123);

        Collection<Integer> intValues = new ArrayList<>();
        Integer max = Example2.max(intValues, "123");

        Example2 example2 = new Example2();
        String s = example2.printHello("123");
        Integer integer = example2.printHello(1);

    }

    public static <R extends Object & Comparable<R>, T> R max(Collection<R> coll, T value) {
        throw new UnsupportedOperationException();
    }

    public <T> T printHello(T value) {
        System.out.println(value + " hello");
        return value;
    }

}

class Holder<T extends Cloneable & Comparable<T>> {

    private final T value;

    Holder(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public <R> T max(List<T> list, R value) {
        throw new UnsupportedOperationException();
    }



    public static Object oldMax(Collection coll) {
        throw new UnsupportedOperationException();
    }
}

class AnotherHolder extends Holder<MyNumber> {

    AnotherHolder(MyNumber value) {
        super(value);
    }
}


class MyNumber extends Number implements Comparable<MyNumber>, Cloneable {

    @Override
    public int compareTo(MyNumber o) {
        return 0;
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}
