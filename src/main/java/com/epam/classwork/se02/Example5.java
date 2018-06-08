package com.epam.classwork.se02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example5 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        MyClonedClass ref1 = new MyClonedClass(list);
        MyClonedClass clone = ref1.clone();

        MyClonedClass constructorClone = new MyClonedClass(ref1);


        System.out.println(ref1 == clone);
        System.out.println(ref1.getList() == clone.getList());

        ref1.getList().set(0, 42);

        System.out.println(clone.getList().get(0));

        AA aa = new AA();
//        aa.clone();

        Class<MyClonedClass> myClonedClassClass = MyClonedClass.class;
        Class<? extends MyClonedClass> aClass = clone.getClass();
    }

}

class MyClonedClass implements Cloneable {

    private final List<Integer> list;

    public MyClonedClass(List<Integer> list) {
        this.list = list;
    }

    public MyClonedClass(MyClonedClass other) {
        list = new ArrayList<>(other.list);
    }

    public static MyClonedClass clone(MyClonedClass other) {
        return new MyClonedClass(new ArrayList<>(other.list));
    }

    public List<Integer> getList() {
        return list;
    }



    @Override
    public MyClonedClass clone() {
        try {
            MyClonedClass clone = (MyClonedClass) super.clone();
//            clone.list = new ArrayList<>(list);
            return clone;
        } catch (CloneNotSupportedException ex) {
            throw new RuntimeException(ex);
        }
    }
}


class S {

    public void method() {
        System.out.println("S");
    }

    public void method2() {

    }
}

class Z extends S {

    protected int field = 43;
    protected double doubleValue2 = 0.4;

    @Override
    public void method() {
        System.out.println("Z");
    }
}

class Y extends Z {

    protected int field = 44;
    private double doubleValue = 0.4;

    public void method() {
        method2();
        System.out.println(field);
    }
}


class AA {

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}