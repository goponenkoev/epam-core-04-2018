package com.epam.classwork.se01;

public class Example12 {

    private static final VeryBigClass[] arr = new VeryBigClass[1_000_000];

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = new VeryBigClass();
            System.out.println(i);
            if (i > 50) {
                arr[i - 49] = null;
            }
            Thread.sleep(100);
        }

        System.gc();
    }


}

class VeryBigClass {

    private final int[] bigField = new int[1_000_000];
}
