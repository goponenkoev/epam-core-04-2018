package com.epam.classwork.se02;

import java.io.File;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class Example9 {

    public static void main(String[] args) throws InterruptedException {
        Vulnerable vulnerable = null;
        try {
            vulnerable = new Atack(-1);
//            System.out.println(vulnerable.getFile());
        } catch (IllegalArgumentException ex) {
            System.out.println(vulnerable);
        }

        int[] arr = new int[1_000_000];
        arr = null;

        System.gc();
        System.gc();
        System.gc();


        TimeUnit.SECONDS.sleep(5);

//        File file = Atack.zomibe.getFile();
//        System.out.println(file);
    }
}


class Speak {

    public static void main(String[] args) {
        Speak speak = new TellIt();
        ((Truth) speak).tellIt();

        Serializable a = (Serializable)speak;


    }
}

class TellIt extends Speak implements Truth {

    @Override
    public void tellIt() {
        System.out.println("123");
    }
}

interface Truth {
    void tellIt();
}

class Vulnerable {

    private final File file = new File("/root/tmp");

    public Vulnerable(int key) {
        this(checkKey(key), null);
    }

    private static int checkKey(int key) {
        if (key < 0) {
            throw new IllegalArgumentException();
        }
        return key;
    }

    private Vulnerable(int key, Void v) {
        super();
    }

}

class Atack extends Vulnerable {

    static Atack zomibe;

    public Atack(int key) {
        super(key);
    }

    @Override
    protected void finalize() {
        System.out.println("Finalize");
        zomibe = this;
    }
}
