package com.epam.classwork.se02.generics;

import java.util.ArrayList;
import java.util.List;

public class Example3 {

    @SuppressWarnings("Convert2Diamond")
    public static void main(String[] args) {
//        ArrayList<Object> listObjects = new ArrayList<String>();

        List<Number> list0 = new ArrayList<>();
        list0.add(1);
        list0.add(1);
        list0.add(1);

        List<? extends Number> list1 = new ArrayList<Number>();
        list1 = list0;

        List<? extends Number> list2 = new ArrayList<Integer>();
        List<? extends Number> list3 = new ArrayList<Long>();

//        list1.add(new Integer(1));
//        list1.add(Math.random());
//        Number number = 34.5;
//        list1.add(number);
//        list1.add(null);


        Number number1 = list2.get(0);
    }

    private static ArrayList<Integer> getList2() {

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        return integers;
    }

    private static ArrayList<Number> getList1() {
        return new ArrayList<Number>();
    }
}
