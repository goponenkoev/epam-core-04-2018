package com.epam.classwork.se06.list;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Example4 {

    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>(6);
        // [_, _, _, _, _, _]
        //  ^

        objects.add(10);
        // [10, _, _, _, _, _]
        //      ^

        System.out.println(objects.remove(0));
        // [_, _, _, _, _, _]
        //  ^

        // [1, 1, 1, 1, 1, 2]
        //                    ^

        objects.add(3);
        // [1, 1, 1, 1, 1, 2]
        // [1, 1, 1, 1, 1, 2, 3, _, _]
        //                       ^

        objects.add(0, 4);
        // [1, 1, 1, 1, 1, 2]
        // [1, 1, 1, 1, 1, 2, 3, _, _]
        // [0, 1, 1, 1, 1, 1, 2, 3, _]
        //                          ^

        objects.trimToSize();

        // [0, 1, 1, 1, 1, 1, 2, 3]


        // 100_000
        ArrayList<Integer> vals = null;
        // 100_000 * (4 + 12)
        // 1_600_000

        // int[] = 100_000 * 4 + 16 = 400_016 + 100

    }
}
