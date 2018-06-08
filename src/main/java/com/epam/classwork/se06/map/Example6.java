package com.epam.classwork.se06.map;

import java.util.HashSet;
import java.util.Set;

public class Example6 {

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Berling");
        set.add("New York");
        System.out.println(set);



        for (Object element : set) {
            System.out.print(element.toString());
        }
    }

}
