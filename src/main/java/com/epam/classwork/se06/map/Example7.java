package com.epam.classwork.se06.map;

import java.util.Collections;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class Example7 {

    public static void main(String[] args) {
        NavigableSet<Integer> integers = new TreeSet<>();
        integers.add(-1);
        integers.add(0);
        integers.add(2);
        integers.add(100);
        integers.add(110);

        Collections.sort(null);


        System.out.println(integers.floor(50));
        SortedSet<Integer> subset = integers.subSet(0, false, 100, true);
        System.out.println(subset);
    }
}
