package com.epam.classwork.se06.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Example3 {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
//        integers.remove("3");
//        System.out.println(integers);

        ListIterator<Integer> listIterator = integers.listIterator();
        System.out.println("[0] = " + listIterator.next());
        System.out.println("[1] = " + listIterator.next());
        System.out.println("[1] = " + listIterator.previous());
//        System.out.println("[0] = " + listIterator.previous());
//        listIterator.set(100500);
        listIterator.remove();

        System.out.println(integers);
    }
}
