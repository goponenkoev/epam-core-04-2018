package com.epam.classwork.se01;

public class Example11 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};

        int[][] twoDimensionalArray1 = new int[][] {
            {1, 2},
            {3, 4},
            {5, 6}
        };


        int[][] twoDimensionalArray2 = new int[3][2];
        System.out.println(twoDimensionalArray2[1][1]);


        String[][] elems = new String[3][3];
        System.out.println(elems[0][0]);

        // {
        // {null, null, null}
        // {null, null, null}
        // {null, null, null}
        // }


        int[][] twoDimArr = new int[3][3];
        // twoDimArr[1][0]
        // 0 0 0 0 0 0 0 0 0 0


        int []twoDim[] = new int[10][10];
        int [][]twoDim1 = new int[10][10];


        byte[][] twoDimensionalArray3 = {
                {1, 2, 3},
                {4, 5},
                {6}
        };

//        Integer[] values = {1, 2, 3, 4};
//        Number[] numbers = values;
//        numbers[0] = 10.5;


        Number[] nums = {1, 2, 3, 4};
        Integer[] intValues = (Integer[]) nums;
        intValues[10] = 5;

        System.out.println(intValues[1]);


        Object objects = new Object[]{1, "123", new Example1()};
        Object o = ((Object[]) objects)[0];

        String[] strings = (String[]) objects;
        Integer[] ints = (Integer[]) objects;
        strings[0] = "123";
        Integer anInt = ints[0];


    }
}
