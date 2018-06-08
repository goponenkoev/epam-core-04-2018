package com.epam.classwork.se02;

public class BaseClass {

    private int privateField;
    int packageField;
    protected int protectedField = 0;
    public int publicField;

    public void method() {

        add(1, 2);
        add2(1, 2);
        add3(2, 4);
    }

    public int add(int val1, int val2) {
        System.out.println("Base: + " + this.protectedField);
        return val1 + val2;
    }

    private int add2(int val1, int val2) {
        return val1 + val2;
    }

    public final int add3(int val1, int val2) {
        return val1 + val2;
    }

    public void baseMethod() {

    }
}

class AnotherClass {

    public static void main(String[] args) {
        BaseClass baseClass = new BaseClass();
        System.out.println(baseClass.packageField);
        System.out.println(baseClass.protectedField);
        System.out.println(baseClass.publicField);
    }
}
