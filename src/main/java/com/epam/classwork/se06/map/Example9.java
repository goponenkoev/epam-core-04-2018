package com.epam.classwork.se06.map;

import java.lang.ref.SoftReference;

public class Example9 {




    public static void main(String[] args) throws InterruptedException {
        Wrapper strongReference = new Wrapper();
        SoftReference<Wrapper> softReference = new SoftReference<>(strongReference);

        strongReference.value = 10;
        System.out.println(strongReference.value);

        Thread.sleep(10_000);


        strongReference = null;

        Wrapper anotherStrongReference = softReference.get();
        if (anotherStrongReference == null) {

        }

        System.out.println(Runtime.getRuntime().freeMemory());
        int[] arr = new int[100_000_000];
        System.out.println(Runtime.getRuntime().freeMemory());

        System.out.println(arr);

        arr = null;

        // 1 mb * s
        //

        System.gc();

        Thread.sleep(5_000);

        System.out.println(Runtime.getRuntime().freeMemory());
    }
}

class Wrapper {

    int value;

}
