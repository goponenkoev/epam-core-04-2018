package com.epam.classwork.se02;

public class Example10 {

    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.getValue());

    }
}

class GrandParent {

    public static int getValue() {
        return 42;
    }
}

class Parent extends GrandParent {

    public static int getValue() {
        return 0;
    }
}

class Child extends Parent {

}
