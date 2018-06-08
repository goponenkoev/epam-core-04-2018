package com.epam.classwork.se02.inner;

public class Example1 {

    private String str = "Hello world";

    public void outerMethod() {
        System.out.println(str);
        System.out.println(new Inner().str);
        System.out.println(Inner.VERSION);
    }

    public static void staticOuterMethod() {
        System.out.println(new Example1().new Inner().str);
    }

    class Inner {

        private String str = "I'm from inner";
        private int value = 42;

        static final String VERSION = "1.0";
//        private static int counter;
//
//        static void staticMethod() {
//
//        }

        void printHello() {
            System.out.println(Example1.this.str);
            System.out.println(value);

        }

        public Example1 getOuterObject() {
            return Example1.this;
        }
    }

    private interface MyInterface {
        void method();
    }

    class A implements MyInterface {

        @Override
        public void method() {
            System.out.println(str);
        }
    }

    class B extends A {

    }
}

class C extends Example1.B {

    public C(Example1 ref) {
        ref.super();
    }

    @Override
    public void method() {
        super.method();
    }
}

class Launcher {

    public static void main(String[] args) {
        Example1 example1 = new Example1();

        Example1.Inner inner = new Example1().new Inner();
        Example1 outerObject = inner.getOuterObject();

        System.out.println(Example1.Inner.VERSION);
    }
}