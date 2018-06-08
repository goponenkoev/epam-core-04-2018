package com.epam.classwork.se01;

import java.util.LinkedList;

import static java.lang.Math.PI;

public class Example6 {

    public static void main(String[] args) {
        System.out.println(PI);
        double nan1 = new Double(0.0 / 0);
        Double nan2 = new Double(0.0 / 0);
        double realNan = Double.NaN;

        System.out.println(Double.isNaN(nan1));
        System.out.println(nan1 == realNan);

        System.out.println(Math.abs(Integer.MIN_VALUE));

        boolean condition = false;

        if (condition) {
            LinkedList<Object> list = new LinkedList<>();
        } else {
            System.out.println();
        }
    }
}
