package com.epam.classwork.se02.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Example6 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> checkedList = Collections.checkedList(list, String.class);
        list.add("1");
        list.add("2");
        list.add("3");

        List raw = checkedList;

        List<Integer> integers = raw;


        integers.add(1);


        Integer integer = integers.get(0);
        System.out.println(integer);
    }
}
