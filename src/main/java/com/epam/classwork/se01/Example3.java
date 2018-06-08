package com.epam.classwork.se01;

public class Example3 {


    // ref -> args
    // ref -> i
    public static void main(String[] args) {
        Integer i = 10;
        System.out.println("i1=" + i);
        changeInteger(i);
        System.out.println("i2=" + i);


        Integer[] data = {1, 2, 3, 4};
        sort(data);
    }

    // ref -> x
    public static void changeInteger(Integer x) {
        System.out.println("x1=" + x);

        ++x;

        if (Integer.valueOf(11) == x) {
            System.out.println("eqauls");
        }
//        x = new Integer(20);
        System.out.println("x2=" + x);
    }


    public static void sort(Integer[] arr) {
        Integer tmp = arr[1];
    }

}
