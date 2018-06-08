package com.epam.classwork.se02;

import java.io.Serializable;
import java.util.Comparator;

public interface MyInterface {

    Double PI = 3.14;

    int getValue();
}

interface PiInerface {
    Double PI = 3.14;

}

interface MyInterface2 extends MyInterface, Serializable {
    Double PI = 3.14;


    int getAnotherValue();
}

abstract class Implementation implements MyInterface2, Serializable, Cloneable {

    public static final Double PI = 3.15;

    public static void main(String[] args) {
        System.out.println(PiInerface.PI);
        System.out.println(MyInterface.PI);


        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };
    }

    @Override
    public int getValue() {
        return 0;
    }
}

