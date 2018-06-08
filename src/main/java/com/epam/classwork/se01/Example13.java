package com.epam.classwork.se01;

import java.util.Arrays;

public class Example13 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[][] source = { arr, null };

//        int[][] other = source.clone();
//
//        System.out.println(arr == source[0]);
//        System.out.println(arr == other[0]);
//
        int[][] ints = Arrays.copyOf(source, source.length);

//        String str = "123";
//        char[] result = new char[str.length()];
//        System.arraycopy(str, 0, result, 0, str.length());

        Number[] obj = null;
        Integer[] values = null;
        System.out.println(obj == values);


        // header
        // 4b
        // 4b
        // 4b
        // values
        // 4b
        // 4b
        // padding
        // 4b


        int[][][] bigArr = new int[2][768][1024];

    }
}
