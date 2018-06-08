package com.epam.classwork.se02.generics;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Example1 {

    public static void main(String[] args) {
//        Object[] objects = new Object[10];
//        objects = new String[10];
//        objects[0] = "abc";
//        objects[1] = 123;


        // After Java5
        ArrayList<String> genericStringList = new ArrayList<>();
        genericStringList.add("Hello world");
        String value3 = genericStringList.get(0);
        System.out.println(value3);


        ArrayList rawList = genericStringList;
        rawList.add(123);

        ////


        System.out.println(rawList.get(1));

        ////


        System.out.println("YAHOOO");
    }

    private static void beforeJava5() {
        ArrayList stringList = new ArrayList();
        stringList.add("Hello world");
        String value1 = (String) stringList.get(0);
        System.out.println(value1);

        stringList.add(123);
        String value2 = (String) stringList.get(1);
        System.out.println(value2);
    }

    private static void createGenericObjects() {
        Message<Integer, String> message = new Message<>();
        Message<Long, StringBuffer> message2 = new Message<>();
        Message<Number, StringBuffer> message3 = new Message<>();

        NonGenericMessage nonGenericMessage = new NonGenericMessage();
        nonGenericMessage.setId(123);
        nonGenericMessage.setId(123L);
        nonGenericMessage.setId(123d);
        nonGenericMessage.setId(123f);


        Number id = nonGenericMessage.getId();
    }
}

class Message <T1 extends Number, T2 extends CharSequence> {
    T1 id;
    T2 name;

    public T1 getId() {
        return id;
    }

    public T2 getName() {
        return name;
    }
}

class NonGenericMessage {
    Number id;
    CharSequence name;

    public void setId(Number id) {
        this.id = id;
    }

    public void setName(CharSequence name) {
        this.name = name;
    }

    public Number getId() {
        return id;
    }

    public CharSequence getName() {
        return name;
    }
}

