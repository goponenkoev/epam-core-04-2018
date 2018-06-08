package com.epam.classwork.se01;

import java.math.BigInteger;

public class Example4 {

    static int field;
    static Integer field1;

    public static void main(String[] args) {
        System.out.println(field);
        System.out.println(field1);

        BigInteger first = BigInteger.valueOf(100);
        BigInteger second = BigInteger.valueOf(100);
        BigInteger result = first.add(second);


        Number n1 = 1;
        Number n2 = 7.1;
        Number[] array = new Integer[] {71, 1, 7};

        Integer[] i3 = (Integer[]) array; // runtime error

    }
}
