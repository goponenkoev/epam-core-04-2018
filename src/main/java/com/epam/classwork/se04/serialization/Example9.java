package com.epam.classwork.se04.serialization;

import lombok.Getter;
import lombok.Setter;

import java.io.*;

public class Example9 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(Singleton.INSTANCE.getId());

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream objectOut = new ObjectOutputStream(out);
        objectOut.writeObject(Singleton.INSTANCE);

        byte[] bytes = out.toByteArray();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        ObjectInputStream objectIn = new ObjectInputStream(in);
        Singleton singleton = (Singleton) objectIn.readObject();

        System.out.println(Singleton.INSTANCE == singleton);
        System.out.println(Singleton.INSTANCE.getClass() == singleton.getClass());
        singleton.setId(10);

        System.out.println(singleton.getId());
        System.out.println(Singleton.INSTANCE.getId());
    }
}

@Getter
@Setter
class Singleton implements Serializable {

    public static final Singleton INSTANCE = new Singleton();

    private int id = 0;

    private Singleton() {}

    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
    }
}

class MyClass implements Serializable {

    private String filed;
    private Singleton singleton;

}
