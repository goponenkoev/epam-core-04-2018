package com.epam.classwork.se06.list;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Example6 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Collection<Integer> there50_000elements = null;

        ListIterator<Integer> iter = list.listIterator(50_000);

        for (Integer there50_000element : there50_000elements) {
            iter.add(there50_000element);
        }
    }
}
