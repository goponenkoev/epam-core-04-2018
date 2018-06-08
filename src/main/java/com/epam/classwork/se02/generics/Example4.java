package com.epam.classwork.se02.generics;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Convert2Diamond")
public class Example4 {

    public static void main(String[] args) {
        List<? super Number> list1 = new ArrayList<Number>();

        ArrayList<Object> object = new ArrayList<>();
        object.add("123");
        List<? super Number> list2 = object;
        List<? super Integer> list3 = new ArrayList<Integer>();


        list1.add(1);
        list1.add(1L);
        Number num = 1;
        list1.add(num);


        Object object1 = list1.get(0);
    }

}


