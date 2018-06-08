package com.epam.classwork.se06.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

@SuppressWarnings("all")
public class Example1 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d");

        System.out.println(list.size());

        for (int i = 0; i < list.size(); ++i) {
            System.out.println(list.get(i));
        }

        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }



        MyCollection myCollection = new MyCollection();
        for (String current : myCollection) {
            System.out.println(current);
        }

        Iterable<String> collection = list;
        Consumer<String> sout = System.out::println;
        Consumer<String> serr = System.err::println;
        collection.forEach(ThreadLocalRandom.current().nextBoolean() ? sout : serr);

    }
}

class MyCollection implements Iterable<String> {

    private final String[] strings = {"a", "e", "f"};

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {

            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < strings.length;
            }

            @Override
            public String next() {
                return strings[currentIndex++];
            }
        };
    }
}
