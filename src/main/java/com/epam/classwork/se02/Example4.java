package com.epam.classwork.se02;

import java.util.logging.Logger;

public class Example4 {




    public static void main(String[] args) throws ClassNotFoundException {
        new D();

    }


}

class B {

    static {
        System.out.println("Static logical block B-1");
    }

    {
        System.out.println("Logical block B-1");
    }

    public B() {
        super();
        System.out.println("Consturctor B");
    }

    {
        System.out.println("Logical block B-2");
    }

    static {
        System.out.println("Static logical block B-2");
    }


}

class C extends B {

    static {
        System.out.println("Static logical block C-1: " + C.FIELD);
    }

    public final static int FIELD = 42;

    {
        finalField = new Object();
        System.out.println("Logical block C-1");
        System.out.println(this.finalField);

        int a = 42;
        System.out.println(a);

    }

    private Object finalField = 42;

    public C(int value1, float value2) {
        System.out.println("Consturctor C");
        System.out.println(finalField);
    }

    public C(int value1) {
        System.out.println("Consturctor C");
        System.out.println(finalField);
    }

    {
        System.out.println("Logical block C-2");

        int a = 43;
        System.out.println(a);
    }

    static {
        System.out.println("Static logical block C-2");
    }
}


class D {

    private static final Logger LOG = initAndCreateRootLogger();
    static {

    }

    public D() {
        LOG.info("Constructor D called");
    }

    private static Logger initAndCreateRootLogger() {
        LOG.info("123");
        //        Logger.config("123.xml");
        //
        return Logger.getLogger("root");
    }
}
