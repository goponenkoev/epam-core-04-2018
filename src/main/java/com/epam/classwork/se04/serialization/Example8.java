package com.epam.classwork.se04.serialization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.*;

public class Example8 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        B b = new B(0);
        A a1 = new A(b);
        A a2 = new A(b);

        System.out.println(a1.getB() == a2.getB());

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream objectOut = new ObjectOutputStream(out);
        objectOut.writeObject(a1);
        objectOut.writeObject(a2);

        byte[] bytes = out.toByteArray();
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes));
        A a1deserialized = (A)in.readObject();
        A a2deserialized = (A)in.readObject();

        System.out.println(a1 == a1deserialized);
        System.out.println(b == a1deserialized.getB());
        System.out.println(a1deserialized.getB() == a2deserialized.getB());
    }
}

@Getter
@AllArgsConstructor
class A implements Serializable {

    B b;
}

@RequiredArgsConstructor
class B implements Serializable {
    final int id;
}
