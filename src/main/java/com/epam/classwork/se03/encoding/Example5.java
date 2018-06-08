package com.epam.classwork.se03.encoding;

import java.util.Locale;

public class Example5 {

    public static void main(String[] args) {
        Integer val = 5;
        Boolean bool = true;
        System.out.printf("%d %2$b %b%n", val, bool);
        System.out.printf("%d %<d %<d %d%n", val, 6);

        double doubleVal = 0.556;
        System.out.printf("%+10.2f%n", doubleVal);
        System.out.printf("%-+10.2f%n", doubleVal);


        int val1 = 1000000;
        int val2 = -1000000;
        System.out.printf("% ,015d%n", val1);
        System.out.printf(new Locale("RU"), "%(,015d%n", val2);


    }
}
