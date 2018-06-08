package com.epam.classwork.se02;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Example8 {

    static Zombie zombie;

    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);

        Zombie bomb = new Zombie();
        System.out.println(bomb);

        bomb = null;

        int[] arr = new int[1_000_000];
        arr = null;

        System.gc();
        System.gc();
        System.gc();

        TimeUnit.SECONDS.sleep(5);

        System.out.println(zombie);

        zombie = null;

        System.gc();
    }
}


class Zombie {

    @Override
    protected void finalize() {
        Example8.zombie = this;
    }
}
