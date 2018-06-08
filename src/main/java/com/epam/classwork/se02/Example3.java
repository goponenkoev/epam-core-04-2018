package com.epam.classwork.se02;

public class Example3 {

    public static void main(String[] args) {
        A a = new A(-1);
        A a2 = new A(-1);
        A a3 = new A(-1);

        A.staticField = 43;
        System.out.println(A.staticField);

        a.method();
        // method(a);

        Class<A> aClass = A.class;
        Class<? extends A> aClass1 = a.getClass();
        System.out.println(aClass == aClass1);
    }
}


// field, field2 > 0
class A extends Object {

    public static int staticField = 42;
    private int field;
    private float field2;

    public A() {
        this(1);
    }

    public A(int field) {
        // code
        // ...

        this(field, 1.0F);
    }

    public A(int field, float field2) {
        super();
        this.field = field;
        this.field2 = field2;
    }

    private static int check(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException();
        }
        return value;
    }

    public void method(A this) {
//        this(field, 1.0F);
        Class<? extends A> aClass = this.getClass();
    }


    public void doSmth(A a) {
        field = a.field;
    }
}