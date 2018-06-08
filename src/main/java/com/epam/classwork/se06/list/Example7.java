package com.epam.classwork.se06.list;

import java.util.ArrayList;
import java.util.List;

public class Example7 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<Integer> anotherList = new ArrayList<>(list.subList(0, 2));
        System.out.println(list == anotherList);
        System.out.println(list.equals(anotherList));
        System.out.println(list);
        System.out.println(anotherList);

        list.set(0, 45);
        System.out.println(list);
        System.out.println(anotherList);
    }
}
