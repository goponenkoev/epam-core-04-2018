package com.epam.classwork.se04;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;

public class Example7 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Student("Alex", "Alexeev", 3);
        person.setPassport(new Passport(1, 1));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutput objectOutput = new ObjectOutputStream(out);

        objectOutput.writeObject(person);



//        try (FileInputStream input = new FileInputStream("person.bak")) {
//            input.read(bytes);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }


        byte[] bytes = out.toByteArray();
        ObjectInputStream objectInput = new ObjectInputStream(new ByteArrayInputStream(bytes));
        Person anotherPerson = (Person)objectInput.readObject();
        System.out.println(anotherPerson);
        System.out.println(person.equals(anotherPerson));
    }
}

@EqualsAndHashCode(exclude = "mood")
@Setter
@Getter
@ToString
class Person {

    static int version = 10;
//    String mood = "norm";
    String name;
    String surname;
    Passport passport;

    public Person() {
        name = "DEFAULT";
        surname = "DEFAULT";
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void method() {
        System.out.println("123");
    }
}

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
class Student extends Person implements Serializable {
    int course;

    public Student(String name, String surname, int course) {
        super(name, surname);
        this.course = course;
    }
}

@ToString
@EqualsAndHashCode
class Passport implements Serializable {

    final int serial;
    final int number;

    Passport(int serial, int number) {
        this.serial = serial;
        this.number = number;
    }
}