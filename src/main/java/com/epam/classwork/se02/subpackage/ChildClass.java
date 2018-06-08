package com.epam.classwork.se02.subpackage;

import com.epam.classwork.se02.BaseClass;

public class ChildClass extends BaseClass {

    @Override
    public void method() {
        System.out.println(protectedField);
        System.out.println(publicField);
    }

    public void method(BaseClass ref) {
        System.out.println(ref.publicField);
//        System.out.println(ref.protectedField);
    }

    public static void main(String[] args) {
        BaseClass ref = new AnotherChildClass();
        if (ref instanceof ChildClass) {
            System.out.println("Yes I am");
        }


        ref.method();

    }
}


class AnotherChildClass extends BaseClass {

    private int privateField;
    int packageField;
    protected int protectedField = 20;
    public int publicField;

    @Override
    public void method() {
        System.out.println("I'm from another child class");
        super.method();
    }

    @Override
    public int add(int val1, int val2) {
        System.out.println("Child: + " + this.protectedField);
        super.add(1, 1);
        return val1 - val2;
    }

    private int add2(int val1, int val2) {
        return val1 - val2;
    }

    public static void main(String[] args) {
        BaseClass baseRef = new AnotherChildClass();
        baseRef.method();
        baseRef.baseMethod();
    }
}