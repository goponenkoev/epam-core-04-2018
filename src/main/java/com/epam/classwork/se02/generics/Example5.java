package com.epam.classwork.se02.generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Example5 {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        Person person1 = new Person(75, 25);
        Person person2 = new Person(90, 35);
        Person person3 = new Person(20, 7);

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        Comparator<PhysicalObejct> ageComparator = new WeightComparator();
        Person greatestWeight = getGreatestWeight(persons, ageComparator);



    }

    // Producer
    // Extends
    // Consumer
    // Super
    private static <T> T getGreatestWeight(List<? extends T> list, Comparator<? super T> comparator) {
        //

        return null;
    }


}


class WeightComparator implements Comparator<PhysicalObejct> {

    @Override
    public int compare(PhysicalObejct o1, PhysicalObejct o2) {
        return Integer.compare(o1.getWeight(), o2.getWeight());
    }
}

class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

abstract class PhysicalObejct {

    private int weight;

    PhysicalObejct(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}

class Person extends PhysicalObejct {

    private int age;

    public Person(int weight, int age) {
        super(weight);
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

class Child extends Person {

    public Child(int weight, int age) {
        super(weight, age);
    }
}