package com.epam.classwork.se06.map;

import java.util.*;

public class Example8 {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");

        List<String> unmodifiableList = Collections.unmodifiableList(strings);


        int[][] matrix = {
                {1, 2, 3},
                {2, 3, 1},
                {2, 2, 1}
        };

        int[][] reversed = {
                {2, 2, 1},
                {2, 3, 1},
                {1, 2, 3}
        };




        List<int[]> list = Arrays.asList(matrix);
        List<int[]> ints1 = Collections.unmodifiableList(list);
        matrix[0][0] = 5;

        Collections.reverse(list);

        System.out.println(Arrays.deepToString(matrix));
        for (int[] ints : list) {
            System.out.println(Arrays.toString(ints));
        }


        Set<Integer> singleton = Collections.singleton(1);

//        method(unmodifiableList);
//        System.out.println(unmodifiableList);
    }

    static void method(List<String> list) {
        list.add("1");
        list.remove("a");
    }
}
